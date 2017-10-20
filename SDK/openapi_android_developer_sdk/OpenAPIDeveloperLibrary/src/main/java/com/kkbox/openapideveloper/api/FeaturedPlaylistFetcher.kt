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
 * @see `https://docs.kkbox.codes/docs/featured-playlists`.
 */
class FeaturedPlaylistFetcher(private val httpClient: HttpClient, private val territory: String = "TW") {
    private val endpoint: String = Endpoint.API.FEATURED_PLAYLISTS.uri

    /**
     * Fetch featured playlists.
     *
     * @param limit The size for one page.
     * @param offset The offset index for first element.
     * @return the API response.
     * @sample FeaturedPlaylistFetcher.fetchAllFeaturedPlaylists()
     * @see `https://docs.kkbox.codes/docs/featured-playlists`
     */
    fun fetchAllFeaturedPlaylists(limit: Int? = null, offset: Int? = null): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint,
                mapOf("territory" to territory,
                        "limit" to limit?.toString(),
                        "offset" to offset?.toString()))
    }
}