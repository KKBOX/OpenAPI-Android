package com.kkbox.openapideveloperclient.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.kkbox.openapiclient.R
import com.kkbox.openapideveloperclient.tracks.TrackInfo
import com.koushikdutta.ion.Ion
import kotlin.collections.ArrayList

/**
 * Created by sharonyang on 2017/9/26.
 */

class TrackListAdapter(private var activity: Activity): BaseAdapter() {

    var items: ArrayList<TrackInfo> = ArrayList()

    private class ViewHolder(row: View?) {
        var txtTrackName: TextView? = null
        var txtArtist: TextView? = null
        var imgAlbum: ImageView? = null

        init {
            this.txtTrackName = row?.findViewById(R.id.txtTrackName) as TextView?
            this.txtArtist = row?.findViewById(R.id.txtArtist) as TextView?
            this.imgAlbum = row?.findViewById(R.id.imgAlbum) as ImageView?
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.track_list_row, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var trackInfo = items[position]
        viewHolder.txtTrackName?.text = trackInfo.name
        viewHolder.txtArtist?.text = trackInfo.artist
        Ion.with(viewHolder.imgAlbum).load(trackInfo.albumImage)

        return view as View
    }

    override fun getItem(i: Int): Any {
        return items[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return  items.size
    }

}




