package com.kkbox.openapidevelopertest.api

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.kkbox.openapideveloper.api.FeaturedPlaylistCategoryFetcher
import com.kkbox.openapideveloper.api.HttpClient
import com.kkbox.openapideveloper.auth.Auth
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class FeaturedPlaylistCategoryFetcherTest {
    private val context: Context = InstrumentationRegistry.getTargetContext()
    private val auth: Auth = Auth(com.kkbox.openapideveloper.ClientInfo.CLIENT_ID, com.kkbox.openapideveloper.ClientInfo.CLIENT_SECRET, context)
    private val accessToken: String = auth.clientCredentialsFlow.fetchAccessToken().get().get("access_token").asString
    private val httpClient: HttpClient = HttpClient(accessToken, context)
    private val featuredPlaylistCategoryFetcher: FeaturedPlaylistCategoryFetcher = FeaturedPlaylistCategoryFetcher(httpClient).setCategoryId("LXUR688EBKRRZydAWb")

    @Test
    fun fetchAllFeaturedPlaylistCategories() {
        Assert.assertTrue(featuredPlaylistCategoryFetcher.fetchAllFeaturedPlaylistCategories().get(10, TimeUnit.SECONDS).has("data"))
    }

    @Test
    fun fetchMetadata() {
        Assert.assertTrue(featuredPlaylistCategoryFetcher.fetchMetadata().get(10, TimeUnit.SECONDS).has("id"))
    }

    @Test
    fun fetchPlaylists() {
        Assert.assertTrue(featuredPlaylistCategoryFetcher.fetchPlaylists().get(10, TimeUnit.SECONDS).has("data"))
    }
}