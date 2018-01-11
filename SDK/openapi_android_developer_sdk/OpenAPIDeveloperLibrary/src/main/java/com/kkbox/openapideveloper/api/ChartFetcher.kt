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
    lateinit var playlistId: String

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

    /**
     * Set the new hits playlist ID.
     *
     * @param playlistId The playlist ID.
     * @return the new hit playlist ID.
     * @see `https://docs-en.kkbox.codes/v1.1/reference#charts-playlist_id`
     */
    fun setPlaylistId(playlistId: String): ChartFetcher {
        this.playlistId = playlistId
        return this
    }

    /**
     * Fetch information of the song ranking by given ID.
     *
     * @return the object of new hits playlist track's metadata.
     * @sample ChartFetcher.setPlaylistId("Wk-z5ZBpPowcmYlS0E").fetchMetadata()
     */
    fun fetchChartsPlaylist(): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint + "/$playlistId", mapOf("territory" to territory))
    }

    /**
     * Fetch and list tracks of a chart by given ID.
     *
     * @return the object of new hits playlist track's metadata.
     * @sample ChartFetcher.setPlaylistId("Wk-z5ZBpPowcmYlS0E").fetchMetadata()
     */
    fun fetchChartsPlaylistTracks(): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint + "/$playlistId/tracks", mapOf("territory" to territory))
    }
}
