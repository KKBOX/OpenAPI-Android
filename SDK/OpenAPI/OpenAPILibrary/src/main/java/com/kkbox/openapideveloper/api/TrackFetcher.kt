package com.kkbox.openapideveloper.api

import com.google.gson.JsonObject
import com.kkbox.openapideveloper.Endpoint
import com.koushikdutta.ion.future.ResponseFuture

/**
 * Fetch metadata of a track.
 *
 * @property httpClient Get response from specific url.
 * @property territory The current territory.
 * @constructor Creates a track fetcher.
 * @see `https://docs.kkbox.codes/docs/tracks`
 */
class TrackFetcher(private val httpClient: HttpClient, private val territory: String = "TW") {
    private val endpoint: String = Endpoint.API.TRACKS.uri
    lateinit var trackId: String

    /**
     * Set the track ID.
     *
     * @param trackId The track ID.
     * @return the track ID.
     * @see `https://docs.kkbox.codes/docs/tracks`
     */
    fun setTrackId(trackId: String): TrackFetcher {
        this.trackId = trackId
        return this
    }

    /**
     * Fetch metadata of a track by given ID.
     *
     * @return the object of the track's metadata.
     * @sample TrackFetcher.setTrackId('SkZOxSOGFd6eCbbVp4').fetchMetadata()
     */
    fun fetchMetadata(): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint + "/$trackId", mapOf("territory" to territory))
    }

    /**
     * Get the widget url of the track.
     *
     * @sample `https://widget.kkbox.com/v1/?id=XY8FPWBiJrx2FI6vgm&type=song`
     * @return the widget url of the track.
     */
    fun getWidgetUri(): String {
        return "https://widget.kkbox.com/v1/?id=$trackId&type=song"
    }
}