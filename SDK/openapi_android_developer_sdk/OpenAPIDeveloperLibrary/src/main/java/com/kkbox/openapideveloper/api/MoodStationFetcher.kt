package com.kkbox.openapideveloper.api

import com.google.gson.JsonObject
import com.kkbox.openapideveloper.Endpoint
import com.koushikdutta.ion.future.ResponseFuture

/**
 * Fetch mood stations and get tracks for a specific mood station.
 *
 * @property httpClient Get response from specific url.
 * @property territory The current territory.
 * @constructor Creates a mood station fetcher.
 * @see `https://docs.kkbox.codes/docs/mood-stations-mood`
 */
class MoodStationFetcher(private val httpClient: HttpClient, private val territory: String = "TW") {
    private val endpoint: String = Endpoint.API.MOOD_STATIONS.uri
    lateinit var moodStationId: String

    /**
     * Fetch all mood stations.
     *
     * @param limit The size for one page.
     * @param offset The offset index for first element.
     * @return the API response.
     * @sample MoodStationFetcher.fetchAllMoodStations()
     * @see `https://docs.kkbox.codes/docs/mood-stations-mood`
     */
    fun fetchAllMoodStations(limit: Int? = null, offset: Int? = null): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint,
                mapOf("territory" to territory,
                        "limit" to limit?.toString(),
                        "offset" to offset?.toString()))
    }

    /**
     * Set a mood station ID.
     *
     * @param moodStationId The station ID.
     * @return the mood station ID.
     * @see `https://docs.kkbox.codes/docs/mood-stations-station`
     */
    fun setMoodStationId(moodStationId: String): MoodStationFetcher {
        this.moodStationId = moodStationId
        return this
    }

    /**
     * Fetch metadata of a mood station by given ID.
     *
     * @return the object of mood station metadata.
     * @sample MoodStationFetcher.setMoodStationId('-msVbZnpWLE4CpWBJo').fetchMetadata()
     */
    fun fetchMetadata(): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint + "/$moodStationId", mapOf("territory" to territory))
    }
}