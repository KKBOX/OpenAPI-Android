package com.kkbox.openapi.api

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.kkbox.openapideveloper.ClientInfo
import com.kkbox.openapi.auth.Auth
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class AlbumFetcherTest {
    private val context: Context = InstrumentationRegistry.getTargetContext()
    private val auth: Auth = Auth(com.kkbox.openapideveloper.ClientInfo.CLIENT_ID, com.kkbox.openapideveloper.ClientInfo.CLIENT_SECRET, context)
    private val accessToken: String = auth.clientCredentialsFlow.fetchAccessToken().get().get("access_token").asString
    private val httpClient: HttpClient = HttpClient(accessToken, context)
    private val albumFetcher: AlbumFetcher = AlbumFetcher(httpClient).setAlbumId("KmRKnW5qmUrTnGRuxF")

    @Test
    fun fetchMetadata() {
        Assert.assertTrue(albumFetcher.fetchMetadata().get(10, TimeUnit.SECONDS).has("id"))
    }

    @Test
    fun getWidgetUri() {
        Assert.assertEquals(albumFetcher.getWidgetUri(),
                "https://widget.kkbox.com/v1/?id=${albumFetcher.albumId}&type=album")
    }

    @Test
    fun fetchTracks() {
        Assert.assertTrue(albumFetcher.fetchTracks().get(10, TimeUnit.SECONDS).has("data"))
    }
}