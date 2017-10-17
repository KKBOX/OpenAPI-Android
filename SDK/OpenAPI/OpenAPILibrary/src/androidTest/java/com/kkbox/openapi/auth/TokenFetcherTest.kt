package com.kkbox.openapideveloper.auth

import android.support.test.InstrumentationRegistry
import android.support.test.filters.FlakyTest
import android.support.test.runner.AndroidJUnit4
import com.kkbox.openapideveloper.ClientInfo
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class TokenFetcherTest {
    private val context = InstrumentationRegistry.getTargetContext()
    private val accessToken: String = com.kkbox.openapideveloper.ClientInfo.ACCESS_TOKEN
    private val tokenFetcher: TokenFetcher = TokenFetcher(com.kkbox.openapideveloper.ClientInfo.CLIENT_ID, com.kkbox.openapideveloper.ClientInfo.CLIENT_SECRET, context)

    @Test
    @FlakyTest
    fun fetchInfo() {
        Assert.assertTrue(tokenFetcher.fetchInfo(accessToken).get(10, TimeUnit.SECONDS).has("exp"))
    }

    @Test
    @FlakyTest
    fun fetchAccessToken() {
        Assert.assertTrue(
                tokenFetcher.fetchAccessToken(
                        mapOf("grant_type" to listOf("client_credentials")))
                        .get(10, TimeUnit.SECONDS)
                        .has("access_token"))
    }

    @Test
    @FlakyTest
    fun refresh() {
        Assert.assertTrue(
                tokenFetcher.refresh("")
                        .get(10, TimeUnit.SECONDS)
                        .has("error"))
    }
}