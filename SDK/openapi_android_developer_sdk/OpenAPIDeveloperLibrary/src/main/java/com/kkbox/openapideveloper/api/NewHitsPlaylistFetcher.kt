package com.kkbox.openapideveloper.api

import com.google.gson.JsonObject
import com.kkbox.openapideveloper.Endpoint
import com.koushikdutta.ion.future.ResponseFuture


/**
 * List all new hits playlists and fetch tracks for specific new hit playlist.
 *
 * @property httpClient Get response from specific url.
 * @property territory The current territory.
 * @constructor Creates a new hits playlist fetcher.
 * @see `https://docs.kkbox.codes/docs/new-hits-playlists`
 */
class NewHitsPlaylistFetcher(private val httpClient: HttpClient, private val territory: String = "TW") {
    private val endpoint: String = Endpoint.API.NEW_HITS_PLAYLISTS.uri
    lateinit var playlistId: String

    /**
     * Fetch all new hits playlists.
     *
     * @param limit The size for one page.
     * @param offset The offset index for first element.
     * @return the API response.
     * @sample NewHitsPlaylistFetcher.fetchAllNewHitsPlaylists()
     * @see `https://docs.kkbox.codes/docs/new-hits-playlists`
     */
    fun fetchAllNewHitsPlaylists(limit: Int? = null, offset: Int? = null): ResponseFuture<JsonObject> {
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
     * @see `https://docs.kkbox.codes/docs/new-hits-playlists-playlist-id`
     */
    fun setPlaylistId(playlistId: String): NewHitsPlaylistFetcher {
        this.playlistId = playlistId
        return this
    }

    /**
     * Fetch new hits playlist by given ID.
     *
     * @return the object of new hits playlist's metadata.
     * @sample NewHitsPlaylistFetcher.setPlaylistId('Wk-z5ZBpPowcmYlS0E').fetchMetadata()
     */
    fun fetchNewHitsPlaylist(): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint + "/$playlistId", mapOf("territory" to territory))
    }

    /**
     * Fetch new hits playlist tracks by given ID.
     *
     * @return the object of new hits playlist track's metadata.
     * @sample NewHitsPlaylistFetcher.setPlaylistId('Wk-z5ZBpPowcmYlS0E').fetchMetadata()
     */
    fun fetchNewHitsPlaylistTracks(): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint + "/$playlistId/tracks", mapOf("territory" to territory))
    }
}