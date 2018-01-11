package com.kkbox.openapidevelopertest.api

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.kkbox.openapideveloper.api.FeaturedPlaylistFetcher
import com.kkbox.openapideveloper.api.HttpClient
import com.kkbox.openapideveloper.auth.Auth
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class FeaturedPlaylistFetcherTest {
    private val context: Context = InstrumentationRegistry.getTargetContext()
    private val auth: Auth = Auth(com.kkbox.openapideveloper.ClientInfo.CLIENT_ID, com.kkbox.openapideveloper.ClientInfo.CLIENT_SECRET, context)
    private val accessToken: String = auth.clientCredentialsFlow.fetchAccessToken().get().get("access_token").asString
    private val httpClient: HttpClient = HttpClient(accessToken, context)
    private val featuredPlaylistFetcher: FeaturedPlaylistFetcher = FeaturedPlaylistFetcher(httpClient)

    @Test
    fun fetchAllFeaturedPlaylists() {
        Assert.assertTrue(featuredPlaylistFetcher.fetchAllFeaturedPlaylists().get(10, TimeUnit.SECONDS).has("data"))
    }

    fun getFirstPlaylistID() : String {
        val data = featuredPlaylistFetcher.fetchAllFeaturedPlaylists().get(10, TimeUnit.SECONDS)
        val playlists = data.getAsJsonArray("data")
        val playlist = playlists[0].asJsonObject
        val playlistID = playlist.get("id").asString
        Assert.assertTrue(playlistID.isNotEmpty())
        return playlistID
    }

    @Test
    fun fetchFeaturedPlaylist() {
        val playlistID = this.getFirstPlaylistID()
        Assert.assertTrue(featuredPlaylistFetcher.setPlaylistId(playlistID).fetchFeaturedPlaylist().get(10, TimeUnit.SECONDS).has("tracks"))
    }

    @Test
    fun fetchFeaturedPlaylistTracks() {
        val playlistID = this.getFirstPlaylistID()
        Assert.assertTrue(featuredPlaylistFetcher.setPlaylistId(playlistID).fetchFeaturedPlaylistTracks().get(10, TimeUnit.SECONDS).has("data"))
    }
}