package com.kkbox.openapideveloper.api

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.kkbox.openapideveloper.ClientInfo
import com.kkbox.openapideveloper.auth.Auth
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class GenreStationFetcherTest {
    private val context: Context = InstrumentationRegistry.getTargetContext()
    private val auth: Auth = Auth(com.kkbox.openapideveloper.ClientInfo.CLIENT_ID, com.kkbox.openapideveloper.ClientInfo.CLIENT_SECRET, context)
    private val accessToken: String = auth.clientCredentialsFlow.fetchAccessToken().get().get("access_token").asString
    private val httpClient: HttpClient = HttpClient(accessToken, context)
    private val genreStationFetcher: GenreStationFetcher = GenreStationFetcher(httpClient).setGenreStationId("TYq3EHFTl-1EOvJM5Y")

    @Test
    fun fetchAllGenreStations() {
        Assert.assertTrue(genreStationFetcher.fetchAllGenreStations().get(10, TimeUnit.SECONDS).has("data"))
    }

    @Test
    fun fetchMetadata() {
        Assert.assertTrue(genreStationFetcher.fetchMetadata().get(10, TimeUnit.SECONDS).has("id"))
    }
}