package com.kkbox.openapidevelopertest.api

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.kkbox.openapideveloper.api.HttpClient
import com.kkbox.openapideveloper.api.NewHitsPlaylistFetcher
import com.kkbox.openapideveloper.auth.Auth
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class NewHitsPlaylistFetcherTest {
    private val context: Context = InstrumentationRegistry.getTargetContext()
    private val auth: Auth = Auth(com.kkbox.openapideveloper.ClientInfo.CLIENT_ID, com.kkbox.openapideveloper.ClientInfo.CLIENT_SECRET, context)
    private val accessToken: String = auth.clientCredentialsFlow.fetchAccessToken().get().get("access_token").asString
    private val httpClient: HttpClient = HttpClient(accessToken, context)
    private val newHitsPlaylistFetcher: NewHitsPlaylistFetcher = NewHitsPlaylistFetcher(httpClient).setPlaylistId("DZni8m29ciOFbRxTJq")

    @Test
    fun fetchAllNewHitsPlaylists() {
        Assert.assertTrue(newHitsPlaylistFetcher.fetchAllNewHitsPlaylists().get(10, TimeUnit.SECONDS).has("data"))
    }

    fun getFirstPlaylistID() : String {
        val data = newHitsPlaylistFetcher.fetchAllNewHitsPlaylists().get(10, TimeUnit.SECONDS)
        val playlists = data.getAsJsonArray("data")
        val playlist = playlists[0].asJsonObject
        val playlistID = playlist.get("id").asString
        Assert.assertTrue(playlistID.isNotEmpty())
        return playlistID
    }

    @Test
    fun fetchNewHitsPlaylist() {
        val playlistID = this.getFirstPlaylistID()
        Assert.assertTrue(newHitsPlaylistFetcher.setPlaylistId(playlistID).fetchNewHitsPlaylist().get(10, TimeUnit.SECONDS).has("tracks"))
    }

    @Test
    fun fetchNewHitsPlaylistTracks() {
        val playlistID = this.getFirstPlaylistID()
        Assert.assertTrue(newHitsPlaylistFetcher.setPlaylistId(playlistID).fetchNewHitsPlaylistTracks().get(10, TimeUnit.SECONDS).has("data"))
    }
}