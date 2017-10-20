package com.kkbox.openapideveloper.api

import com.google.gson.JsonObject
import com.kkbox.openapideveloper.Endpoint
import com.koushikdutta.ion.future.ResponseFuture

/**
 * Search API, the types it can search includes artists, albums, tracks, or playlists.
 * Default to search all types, use "," to separate types if you want to use multiple
 * types to search at the same time.
 *
 * @property httpClient Get response from specific url.
 * @property territory The current territory.
 * @see `https://docs.kkbox.codes/docs/search`
 */
class SearchFetcher(private val httpClient: HttpClient, private val territory: String = "TW") {
    private val endpoint: String = Endpoint.API.SEARCH.uri
    lateinit var q: String
    var type: String? = null

    /**
     * Search within KKBOX's database.
     *
     * @param q The keyword.
     * @param type The search types.
     * @return the API response.
     * @see `https://docs.kkbox.codes/docs/search`
     */
    fun setSearchCriteria(q: String, type: String? = null): SearchFetcher {
        this.q = q
        this.type = type
        return this
    }

    /**
     * Fetch the search result.
     *
     * @param limit The size for one page.
     * @param offset The offset index for first element.
     * @return the API response.
     * @sample SearchFetcher.setSearchCriteria('hello', 'track').fetchSearchResult()
     * @see `https://docs.kkbox.codes/docs/search`
     */
    fun fetchSearchResult(limit: Int? = null, offset: Int? = null): ResponseFuture<JsonObject> {
        return this.httpClient.get(endpoint,
                mapOf("q" to q,
                        "type" to type,
                        "territory" to territory,
                        "limit" to limit?.toString(),
                        "offset" to offset?.toString()))
    }
}