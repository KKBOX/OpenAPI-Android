package com.kkbox.openapidevelopertest.api

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.kkbox.openapideveloper.api.ArtistFetcher
import com.kkbox.openapideveloper.api.HttpClient
import com.kkbox.openapideveloper.auth.Auth
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class ArtistFetcherTest {
    private val context: Context = InstrumentationRegistry.getTargetContext()
    private val auth: Auth = Auth(com.kkbox.openapideveloper.ClientInfo.CLIENT_ID, com.kkbox.openapideveloper.ClientInfo.CLIENT_SECRET, context)
    private val accessToken: String = auth.clientCredentialsFlow.fetchAccessToken().get().get("access_token").asString
    private val httpClient: HttpClient = HttpClient(accessToken, context)
    private val artistFetcher: ArtistFetcher = ArtistFetcher(httpClient).setArtistId("Cnv_K6i5Ft4y41SxLy")

    @Test
    fun fetchMetadata() {
        Assert.assertTrue(artistFetcher.fetchMetadata().get(10, TimeUnit.SECONDS).has("id"))
    }

    @Test
    fun fetchAlbums() {
        Assert.assertTrue(artistFetcher.fetchAlbums().get(10, TimeUnit.SECONDS).has("data"))
    }

    @Test
    fun fetchTopTracks() {
        Assert.assertTrue(artistFetcher.fetchTopTracks().get(10, TimeUnit.SECONDS).has("data"))
    }

    @Test
    fun fetchRelatedArtists() {
        Assert.assertTrue(artistFetcher.fetchRelatedArtists().get(10, TimeUnit.SECONDS).has("data"))
    }
}