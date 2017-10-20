package com.kkbox.openapideveloper.api

import com.google.gson.JsonObject
import com.kkbox.openapideveloper.Endpoint
import com.koushikdutta.ion.future.ResponseFuture

/**
 * Get artist metadata.
 *
 * @property httpClient The http client for handling http request.
 * @property territory Specify the territory for accessing various apis.
 * @constructor Creates an artist fetcher.
 * @see `https://docs.kkbox.codes/docs/artists`
 */
class ArtistFetcher(private val httpClient: HttpClient, private val territory: String = "TW") {
    private val endpoint: String = Endpoint.API.ARTISTS.uri
    lateinit var artistId: String

    /**
     * Init the artist object.
     *
     * @param artistId The id of an artist.
     * @return the ArtistFetcher object.
     * @see `https://docs.kkbox.codes/docs/artists`
     */
    fun setArtistId(artistId: String): ArtistFetcher {
        this.artistId = artistId
        return this
    }

    /**
     * Fetches metadata of an artist.
     *
     * @return the artist's metadata object.
     * @sample ArtistFetcher.setArtistId('Cnv_K6i5Ft4y41SxLy').fetchMetadata()
     */
    fun fetchMetadata(): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint + "/$artistId", mapOf("territory" to territory))
    }

    /**
     * Fetch albums belong to an artist.
     *
     * @param limit the size for one page.
     * @param offset the offset index for first element.
     * @return albums belong to the Artist.
     * @sample ArtistFetcher.setArtistId('Cnv_K6i5Ft4y41SxLy').fetchAlbums()
     * @see `https://docs.kkbox.codes/docs/artists-albums`
     */
    fun fetchAlbums(limit: Int? = null, offset: Int? = null): ResponseFuture<JsonObject> {
        return httpClient.get("$endpoint/$artistId/albums",
                mapOf("territory" to territory,
                        "limit" to limit?.toString(),
                        "offset" to offset?.toString()))
    }

    /**
     * Fetch top tracks belong to an artist.
     *
     * @param limit the size for one page.
     * @param offset the offset index for first element.
     * @return top tracks belong to an artist.
     * @sample ArtistFetcher.setArtistId('Cnv_K6i5Ft4y41SxLy').fetchTopTracks()
     * @see `https://docs.kkbox.codes/docs/artists-top-tracks`
     */
    fun fetchTopTracks(limit: Int? = null, offset: Int? = null): ResponseFuture<JsonObject> {
        return httpClient.get("$endpoint/$artistId/top-tracks",
                mapOf("territory" to territory,
                        "limit" to limit?.toString(),
                        "offset" to offset?.toString()))
    }
}