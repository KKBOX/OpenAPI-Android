package com.kkbox.openapideveloper.api

import com.google.gson.JsonObject
import com.kkbox.openapideveloper.Endpoint
import com.koushikdutta.ion.future.ResponseFuture

/**
 * List featured playlist categories.
 *
 * @property httpClient Get response from specific url.
 * @property territory The current territory.
 * @see `https://docs.kkbox.codes/docs/featured-playlist-categories`
 */
class FeaturedPlaylistCategoryFetcher(private val httpClient: HttpClient, private val territory: String = "TW") {
    private val endpoint: String = Endpoint.API.FEATURED_PLAYLISTS_CATEGORIES.uri
    lateinit var categoryId: String

    /**
     * Init the featured playlist category fetcher.
     *
     * @param categoryId The category ID.
     * @return the FeaturedPlaylistCategoryFetcher object.
     * @see `https://docs.kkbox.codes/docs/feature-playlist-category`
     */
    fun setCategoryId(categoryId: String): FeaturedPlaylistCategoryFetcher {
        this.categoryId = categoryId
        return this
    }

    /**
     * Fetch all featured playlist categories.
     *
     * @return all featured playlist categories.
     * @sample FeaturedPlaylistCategoryFetcher.fetchAllFeaturedPlaylistCategories()
     * @see `https://docs.kkbox.codes/docs/featured-playlist-categories`
     */
    fun fetchAllFeaturedPlaylistCategories(limit: Int? = null, offset: Int? = null): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint,
                mapOf("territory" to territory,
                        "limit" to limit?.toString(),
                        "offset" to offset?.toString()))
    }

    /**
     * Fetch metadata of the category you init.
     *
     * @return the category's metadata object.
     * @sample FeaturedPlaylistCategoryFetcher.setCategoryId('LXUR688EBKRRZydAWb').fetchMetadata()
     */
    fun fetchMetadata(): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint + "/$categoryId", mapOf("territory" to territory))
    }

    /**
     * Fetch featured playlists of the category with the category fetcher you init. Result will be paged.
     *
     * @param limit The size of one page.
     * @param offset The offset index for first element.
     * @return playlists of the category.
     * @sample FeaturedPlaylistCategoryFetcher.setCategoryId('LXUR688EBKRRZydAWb').fetchPlaylists()
     * @see `https://docs.kkbox.codes/docs/featured-playlist-categoriescategoriesplaylists`
     */
    fun fetchPlaylists(limit: Int? = null, offset: Int? = null): ResponseFuture<JsonObject> {
        return httpClient.get("$endpoint/$categoryId/playlists",
                mapOf("territory" to territory,
                        "limit" to limit?.toString(),
                        "offset" to offset?.toString()))
    }
}