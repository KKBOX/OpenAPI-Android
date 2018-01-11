package com.kkbox.openapideveloper.api

import com.google.gson.JsonObject
import com.kkbox.openapideveloper.Endpoint
import com.koushikdutta.ion.future.ResponseFuture

/**
 * List all featured playlists metadata.
 *
 * @property httpClient Get response from specific url.
 * @property territory The current territory.
 * @constructor Creates a featured playlist fetcher.
 * @see `https://docs-en.kkbox.codes/v1.1/reference#featured-playlists`.
 */
class FeaturedPlaylistFetcher(private val httpClient: HttpClient, private val territory: String = "TW") {
    private val endpoint: String = Endpoint.API.FEATURED_PLAYLISTS.uri
    lateinit var playlistId: String

    /**
     * Fetch featured playlists.
     *
     * @param limit The size for one page.
     * @param offset The offset index for first element.
     * @return the API response.
     * @sample FeaturedPlaylistFetcher.fetchAllFeaturedPlaylists()
     * @see `https://docs-en.kkbox.codes/v1.1/reference#featuredplaylists`
     */
    fun fetchAllFeaturedPlaylists(limit: Int? = null, offset: Int? = null): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint,
                mapOf("territory" to territory,
                        "limit" to limit?.toString(),
                        "offset" to offset?.toString()))
    }

    /**
     * Set the featured playlist ID.
     *
     * @param playlistId The playlist ID.
     * @return the featured playlist ID.
     * @see `https://docs-en.kkbox.codes/v1.1/reference#featuredplaylists-playlist_id`
     */
    fun setPlaylistId(playlistId: String): FeaturedPlaylistFetcher {
        this.playlistId = playlistId
        return this
    }

    /**
     * Fetch featured playlist by given ID.
     *
     * @return the object of featured playlist's metadata.
     * @sample FeaturedPlaylistFetcher.setPlaylistId("Wk-z5ZBpPowcmYlS0E").fetchMetadata()
     */
    fun fetchFeaturedPlaylist(): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint + "/$playlistId", mapOf("territory" to territory))
    }

    /**
     * Fetch featured playlist tracks by given ID.
     *
     * @return the object of featured playlist track's metadata.
     * @sample FeaturedPlaylistFetcher.setPlaylistId("Wk-z5ZBpPowcmYlS0E").fetchMetadata()
     */
    fun fetchFeaturedPlaylistTracks(): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint + "/$playlistId/tracks", mapOf("territory" to territory))
    }
}