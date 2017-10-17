package com.kkbox.openapideveloper.api

import com.google.gson.JsonObject
import com.kkbox.openapideveloper.Endpoint
import com.koushikdutta.ion.future.ResponseFuture

/**
 * List categories of new release category and get metadata of specific new release category.
 *
 * @property httpClient Get response from specific url.
 * @property territory The current territory.
 * @constructor Creates a new release category fetcher.
 * @see `https://docs.kkbox.codes/docs/new-release-categories`
 */
class NewReleaseCategoryFetcher(private val httpClient: HttpClient, private val territory: String = "TW") {
    private val endpoint: String = Endpoint.API.NEW_RELEASE_CATEGORIES.uri
    lateinit var categoryId: String

    /**
     * Fetch all new release categories.
     *
     * @param limit The size for one page.
     * @param offset The offset index for first element.
     * @return the API response.
     * @sample NewReleaseCategoryFetcher.fetchAllNewReleaseCategories()
     * @see `https://docs.kkbox.codes/docs/new-release-categories`
     */
    fun fetchAllNewReleaseCategories(limit: Int? = null, offset: Int? = null): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint,
                mapOf("territory" to territory,
                        "limit" to limit?.toString(),
                        "offset" to offset?.toString()))
    }

    /**
     * Set the category ID
     *
     * @param categoryId the category ID.
     * @return the new release category ID.
     * @see `https://docs.kkbox.codes/docs/new-release-categories-category-id`
     */
    fun setCategoryId(categoryId: String): NewReleaseCategoryFetcher {
        this.categoryId = categoryId
        return this
    }

    /**
     * Fetch new release category by given ID.
     *
     * @return the object of new release category's metadata.
     * @sample NewReleaseCategoryFetcher.setCategoryId('1ZQwmFTaLE4p7BG-Ua').fetchMetadata()
     */
    fun fetchMetadata(): ResponseFuture<JsonObject> {
        return httpClient.get(endpoint + "/$categoryId", mapOf("territory" to territory))
    }

    /**
     * Fetch albums of new release category by given ID
     *
     * @param limit The size for one page.
     * @param offset The offset index for first element.
     * @sample NewReleaseCategoryFetcher.setCategoryId('1ZQwmFTaLE4p7BG-Ua').fetchAlbums()
     * @return the API response.
     * @see `https://docs.kkbox.codes/docs/new-release-categories-category-id-albums`
     */
    fun fetchAlbums(limit: Int? = null, offset: Int? = null): ResponseFuture<JsonObject> {
        return httpClient.get("$endpoint/$categoryId/albums",
                mapOf("territory" to territory,
                        "limit" to limit?.toString(),
                        "offset" to offset?.toString()))
    }
}