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
class SharedPlaylistFetcherTest {
    private val context: Context = InstrumentationRegistry.getTargetContext()
    private val auth: Auth = Auth(com.kkbox.openapideveloper.ClientInfo.CLIENT_ID, com.kkbox.openapideveloper.ClientInfo.CLIENT_SECRET, context)
    private val accessToken: String = auth.clientCredentialsFlow.fetchAccessToken().get().get("access_token").asString
    private val httpClient: HttpClient = HttpClient(accessToken, context)
    private val sharedPlaylistFetcher: SharedPlaylistFetcher = SharedPlaylistFetcher(httpClient).setPlaylistId("4nUZM-TY2aVxZ2xaA-")

    @Test
    fun fetchMetadata() {
        Assert.assertTrue(sharedPlaylistFetcher.fetchMetadata().get(10, TimeUnit.SECONDS).has("id"))
    }

    @Test
    fun getWidgetUri() {
        Assert.assertEquals(sharedPlaylistFetcher.getWidgetUri(),
                "https://widget.kkbox.com/v1/?id=${sharedPlaylistFetcher.playlistId}&type=playlist")
    }

    @Test
    fun fetchTracks() {
        Assert.assertTrue(sharedPlaylistFetcher.fetchTracks().get(10, TimeUnit.SECONDS).has("data"))
    }
}