package com.kkbox.openapideveloper.api

import com.google.gson.JsonObject
import com.kkbox.openapideveloper.Endpoint
import com.koushikdutta.ion.future.ResponseFuture


/**
 * Fetch genre stations and get tracks for a specific genre station.
 *
 * @property httpClient Get response from specific url.
 * @property territory The current territory.
 * @constructor Creates a genre station fetcher.
 * @see `https://docs.kkbox.codes/docs/genre-stations-genre`
 */
class GenreStationFetcher(private val httpClient: HttpClient, private val territory: String = "TW") {
    private val endpoint: String = Endpoint.API.GENRE_STATIONS.uri
    lateinit var genreStationId: String

    /**
     * Fetch all genre stations.
     *
     * @param limit The size for one page.
     * @param offset The offset index for first element.
     * @return the API response.
     * @sample GenreStationFetcher.setGenreStationId('9ax4APKMtg7NqOqhNp').fetchAllGenreStation()
     * @see `https://docs.kkbox.codes/docs/genre-stations-genre`
     */
    fun fetchAllGenreStations(limit: Int? = null, offset: Int? = null): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint,
                mapOf("territory" to territory,
                        "limit" to limit?.toString(),
                        "offset" to offset?.toString()))
    }

    /**
     * Set a genre station ID.
     *
     * @param genreStationId The station ID.
     * @return the genreStation ID.
     * @see `https://docs.kkbox.codes/docs/genre-stations-station`
     */
    fun setGenreStationId(genreStationId: String): GenreStationFetcher {
        this.genreStationId = genreStationId
        return this
    }

    /**
     * Fetch metadata of a genre station by given ID.
     *
     * @return the object of genre stations metadata.
     * @sample GenreStationFetcher.setGenreStationId('KmRKnW5qmUrTnGRuxF').fetchMetadata()
     */
    fun fetchMetadata(): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint + "/$genreStationId", mapOf("territory" to territory))
    }
}