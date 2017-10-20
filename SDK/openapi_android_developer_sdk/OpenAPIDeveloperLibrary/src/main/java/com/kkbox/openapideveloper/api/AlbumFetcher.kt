package com.kkbox.openapideveloper.api

import com.google.gson.JsonObject
import com.kkbox.openapideveloper.Endpoint
import com.koushikdutta.ion.future.ResponseFuture

/**
 * Get metadata and tracks of an album.
 *
 * @property httpClient Get response from specific url.
 * @property territory The current territory.
 * @constructor Creates an album fetcher.
 * @see `https://docs.kkbox.codes/docs/albums`.
 */
class AlbumFetcher(private val httpClient: HttpClient, private val territory: String = "TW") {
    private val endpoint: String = Endpoint.API.ALBUMS.uri
    lateinit var albumId: String

    /**
     * Set the album ID.
     *
     * @param albumId The album ID.
     * @return the AlbumFetcher object.
     * @see `https://docs.kkbox.codes/docs/albums`.
     */
    fun setAlbumId(albumId: String): AlbumFetcher {
        this.albumId = albumId
        return this
    }

    /**
     * Fetches metadata of an album by given ID.
     *
     * @return the album's metadata object.
     * @sample AlbumFetcher.setAlbumId('KmRKnW5qmUrTnGRuxF').fetchMetadata()
     */
    fun fetchMetadata(): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint + "/$albumId", mapOf("territory" to territory))
    }

    /**
     * Get the widget url of the album.
     *
     * @sample `https://widget.kkbox.com/v1/?id=4qtXcj31wYJTRZbb23&type=album`
     * @return the widget url of the album.
     */
    fun getWidgetUri(): String {
        return "https://widget.kkbox.com/v1/?id=$albumId&type=album"
    }

    /**
     * Fetches tracks in an album by given ID.
     *
     * @param limit The size for one page.
     * @param offset The offset index for first element.
     * @return tracks of the album.
     * @sample AlbumFetcher.setAlbumId('KmRKnW5qmUrTnGRuxF').fetchTracks()
     * @see `https://docs.kkbox.codes/docs/albums-tracks`
     */
    fun fetchTracks(limit: Int? = null, offset: Int? = null): ResponseFuture<JsonObject> {
        return httpClient.get("$endpoint/$albumId/tracks",
                mapOf("territory" to territory,
                        "limit" to limit?.toString(),
                        "offset" to offset?.toString()))
    }
}