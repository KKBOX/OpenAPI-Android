package com.kkbox.openapideveloper.api

import android.content.Context
import android.net.Uri
import android.util.Log
import com.google.gson.JsonObject
import com.koushikdutta.ion.Ion
import com.koushikdutta.ion.future.ResponseFuture

/**
 * The http client instance will get response from specific url.
 *
 * @property token The token for accessing kkbox open api.
 * @property context The context needed for creating http connection.
 * @constructor Creates a http client instance
 */
class HttpClient(token: String, private val context: Context) {
    private val token: String = "Bearer " + token

    /**
     * Get the result from the passed in url.
     *
     * @param endpoint The api endpoint
     * @param params The query part of the url
     * @return the Future object that will return the http response
     */
    fun get(endpoint: String, params: Map<String, String?> = emptyMap()): ResponseFuture<JsonObject> {
        val builder: Uri.Builder = Uri.parse(endpoint).buildUpon()
        params.keys
                .filter { params[it] != null }
                .forEach { builder.appendQueryParameter(it, params[it]) }
        val resultUri = builder.build()

        return Ion.with(context)
                .load(resultUri.toString())
                .setHeader("Authorization", token)
                .setHeader("User-Agent", "KKBOX Openapi Android SDK")
                .setLogging("http-client", Log.DEBUG)
                .asJsonObject()
    }

    /**
     * Http post method.
     *
     * @param endpoint - Uri endpoint.
     * @param data - Json body data.
     * @return the Future object that will return the http response
     */
    fun post(endpoint: String, data: JsonObject): ResponseFuture<JsonObject> {
        return Ion.with(context)
                .load(endpoint)
                .setHeader("Authorization", token)
                .setHeader("User-Agent", "KKBOX Android SDK")
                .setJsonObjectBody(data)
                .asJsonObject()
    }
}
