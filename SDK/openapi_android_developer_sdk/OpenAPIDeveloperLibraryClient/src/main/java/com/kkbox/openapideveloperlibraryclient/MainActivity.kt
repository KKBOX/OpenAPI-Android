package com.kkbox.openapideveloperlibraryclient

import android.content.Context
import android.os.AsyncTask

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AbsListView
import android.widget.ListView
import android.widget.SearchView
import com.google.gson.JsonObject

import com.kkbox.openapideveloper.api.Api
import com.kkbox.openapideveloper.auth.Auth
import com.kkbox.openapideveloperlibraryclient.adapters.TrackListAdapter
import com.kkbox.openapideveloperlibraryclient.tracks.TrackInfo


class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var auth: Auth
    private lateinit var accessToken: String
    private lateinit var api: Api

    private var listView:ListView? = null
    private var searchView:SearchView? = null
    private var hasMore = true
    private var loading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this.applicationContext
        auth = Auth(com.kkbox.openapideveloper.ClientInfo.CLIENT_ID, com.kkbox.openapideveloper.ClientInfo.CLIENT_SECRET, context)
        accessToken= auth.clientCredentialsFlow.fetchAccessToken().get().get("access_token").asString
        api = Api(accessToken, "TW", context)

        searchView = findViewById(R.id.search_bar) as SearchView?
        searchView?.setOnQueryTextListener(onQueryTextListener)

        listView = findViewById(R.id.listView) as ListView?
        val adapter = TrackListAdapter(this)
        listView?.adapter = adapter
        listView?.setOnScrollListener(object: AbsListView.OnScrollListener {
            override fun onScrollStateChanged(var1: AbsListView ,var2: Int) {
            }
            override fun onScroll(view: AbsListView, firstVisibleItem: Int,
                                  visibleItemCount: Int, totalItemCount: Int) {
                if(firstVisibleItem+visibleItemCount == totalItemCount && totalItemCount!=0)
                {
                    if (!loading)
                    {
                        fetchMoreData()
                    }
                }
            }
        })
    }

    private val onQueryTextListener = object: SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(q: String): Boolean {
            generateData(q)
            return false
        }

        override fun onQueryTextChange(newText: String): Boolean {
            return false
        }
    }

    private fun fetchMoreData() {
        loading = true
        val trackListAdapter = listView?.adapter as TrackListAdapter
        val offset = trackListAdapter.items.size

        AsyncTask.execute({
            val result = ArrayList<TrackInfo>()

            val searchResult = api.searchFetcher.fetchSearchResult(offset=offset).get()
            parseSearchResult(searchResult, result)

            val paging = searchResult.getAsJsonObject("tracks")?.getAsJsonObject("paging")
            val nextUri = paging?.get("next")
            hasMore = if (nextUri != null) !nextUri.isJsonNull else false
            this.runOnUiThread {
                trackListAdapter.items.addAll(result)
                trackListAdapter.notifyDataSetChanged()
                loading = false
            }
        })
    }

    private fun generateData(q: String) {
        loading = true
        AsyncTask.execute({
            val result = ArrayList<TrackInfo>()

            api.searchFetcher.setSearchCriteria(q)

            val searchResult = api.searchFetcher.fetchSearchResult().get()
            parseSearchResult(searchResult, result)

            val paging = searchResult.getAsJsonObject("tracks")?.getAsJsonObject("paging")
            val nextUri = paging?.get("next")
            hasMore = if (nextUri != null) !nextUri.isJsonNull else false
            this.runOnUiThread {
                val trackListAdapter = listView?.adapter as TrackListAdapter
                trackListAdapter.items = result
                trackListAdapter.notifyDataSetChanged()
                loading = false
            }
        })
    }

    private fun parseSearchResult(searchResult: JsonObject, result: ArrayList<TrackInfo>) {
        if (searchResult.isJsonNull) {
            return
        }
        val tracksObj = searchResult.getAsJsonObject("tracks")
        val tracks = tracksObj?.getAsJsonArray("data")

        tracks?.forEach {
            val track = it.asJsonObject
            val trackName = track.get("name").asJsonPrimitive.asString

            val album = track.getAsJsonObject("album")
            val images = album.getAsJsonArray("images").get(0).asJsonObject
            val albumImage = images.get("url").asJsonPrimitive.asString

            val artist = album.getAsJsonObject("artist")
            val artistName = artist.get("name").asJsonPrimitive.asString

            val trackInfo = TrackInfo(trackName, artistName, albumImage)
            result.add(trackInfo)
        }
    }
}
