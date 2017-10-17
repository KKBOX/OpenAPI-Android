package com.kkbox.openapideveloper.api

import com.google.gson.JsonObject
import com.kkbox.openapideveloper.Endpoint
import com.koushikdutta.async.future.Future
import com.koushikdutta.ion.future.ResponseFuture

import java.util.HashMap

/**
 * Fetches various kkbox charts.
 *
 * @property httpClient the http client for handling http request
 * @property territory specify the territory for accessing various apis
 * @constructor creates a chart fetcher.
 */
class ChartFetcher(private val httpClient: HttpClient, private val territory: String = "TW") {
    private val endpoint: String = Endpoint.API.CHARTS.uri

    /**
     * Fetches all charts.
     *
     * @param limit the size for one page.
     * @param offset the offset index for first element.
     * @return the Future object that will return the response
     */
    fun fetchCharts(limit: Int? = null, offset: Int? = null): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint,
                mapOf("territory" to territory,
                        "limit" to limit?.toString(),
                        "offset" to offset?.toString()))
    }
}
