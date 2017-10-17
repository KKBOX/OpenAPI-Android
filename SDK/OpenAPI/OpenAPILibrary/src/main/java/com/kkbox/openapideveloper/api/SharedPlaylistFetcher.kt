package com.kkbox.openapideveloper.api

import com.google.gson.JsonObject
import com.kkbox.openapideveloper.Endpoint
import com.koushikdutta.ion.future.ResponseFuture

/**
 * Fetch metadata and tracks of a specific shared playlist.
 *
 * @property httpClient Get response from specific url.
 * @property territory The current territory.
 * @constructor Creates a shared playlist fetcher.
 * @see `https://docs.kkbox.codes/docs/shared-playlists`.
 */
class SharedPlaylistFetcher(private val httpClient: HttpClient, private val territory: String = "TW") {
    private val endpoint: String = Endpoint.API.SHARED_PLAYLISTS.uri
    lateinit var playlistId: String

    /**
     * Set the shared playlist ID.
     *
     * @param playlistId The playlist ID.
     * @return the shared playlist ID.
     * @see `https://docs.kkbox.codes/docs/shared-playlists`.
     */
    fun setPlaylistId(playlistId: String): SharedPlaylistFetcher {
        this.playlistId = playlistId
        return this
    }

    /**
     * Fetch the shared playlist by given ID.
     *
     * @return the object of the shared playlist's metadata.
     * @sample SharedPlaylistFetcher.setPlaylistId('4nUZM-TY2aVxZ2xaA-').fetchMetadata()
     */
    fun fetchMetadata(): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint + "/$playlistId", mapOf("territory" to territory))
    }

    /**
     * Get the widget url of the album.
     *
     * @sample `https://widget.kkbox.com/v1/?id=GpynX-46F7KFlp14jN&type=playlist&terr=tw&lang=tc`
     * @return the widget url of the shared plalyist.
     */
    fun getWidgetUri(): String {
        return "https://widget.kkbox.com/v1/?id=$playlistId&type=playlist"
    }

    /**
     * Fetch track list of a playlist by given ID.
     * @param limit The size for one page.
     * @param offset The offset index for first element.
     * @return the API response.
     * @sample SharedPlaylistFetcher.setPlaylistId('4nUZM-TY2aVxZ2xaA-').fetchTracks()
     * See `https://docs.kkbox.codes/docs/shared-playlistsplaylist_idtrackss`
     */
    fun fetchTracks(limit: Int? = null, offset: Int? = null): ResponseFuture<JsonObject> {
        return httpClient.get("$endpoint/$playlistId/tracks",
                mapOf("territory" to territory,
                        "limit" to limit?.toString(),
                        "offset" to offset?.toString()))
    }
}