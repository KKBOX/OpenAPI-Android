package com.kkbox.yunwenlin.smart_speaker

import java.io.IOException

import com.squareup.okhttp.MediaType
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.RequestBody
import com.squareup.okhttp.Response
import com.squareup.okhttp.HttpUrl
import com.squareup.okhttp.Call
import java.net.URL

class KKboxOpenAPIClient {

    internal var client = OkHttpClient()

    // code request code here
    @Throws(IOException::class)
    internal fun doSearch(query: String, type:String, territory: String): String {
        var urlBuilder: HttpUrl.Builder = HttpUrl.parse("https://api.kkbox.com/v1.1/search").newBuilder()
        urlBuilder.addQueryParameter("q", query)
        urlBuilder.addQueryParameter("type", type)
        urlBuilder.addQueryParameter("territory", territory)
        val url = urlBuilder.build().toString()

        println("url: " + url)
        val request = Request.Builder()
                .header("Authorization", "Bearer aqWeSge9KuYrhtoV9PpZyQ==")
                .url(url)
                .build()
        println(request)
        val response: Response = client.newCall(request).execute()
        println("response: " + response.body().string())
        return response.body().string()
    }

    // test data
    internal fun bowlingJson(player1: String, player2: String): String {
        return "{'winCondition':'HIGH_SCORE'," + "'name':'Bowling',"+"'round':4,"+"'lastSaved':1367702411696,"+"'dateStarted':1367702378785,"+"'players':["+"{'name':'" + player1 + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"+"{'name':'" + player2 + "','history':[6,10,5,10,10],'color':-48060,'total':41}"+"]}"
    }

    // post request code here
    @Throws(IOException::class)
    internal fun doPostRequest(url: String, json: String): String {
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder()
                .url(url)
                .post(body)
                .build()
        val response = client.newCall(request).execute()
        return response.body().string()
    }

    companion object {
        val JSON = MediaType.parse("application/json; charset=utf-8")

        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {

            // issue the Get request
            val example = KKboxOpenAPIClient()
            val getResponse = example.doSearch("hello", "track", "TW")
            println(getResponse)

            // issue the post request
            val json = example.bowlingJson("Jesse", "Jake")
            val postResponse = example.doPostRequest("http://www.roundsapp.com/post", json)
            println(postResponse)
        }
    }

}