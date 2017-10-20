package com.kkbox.openapidevelopertest.auth

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.kkbox.openapideveloper.auth.ClientCredentialsFlow
import com.kkbox.openapideveloper.auth.TokenFetcher
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class ClientCredentialsFlowTest {
    private val context = InstrumentationRegistry.getTargetContext()
    private val tokenFetcher: TokenFetcher = TokenFetcher(com.kkbox.openapideveloper.ClientInfo.CLIENT_ID, com.kkbox.openapideveloper.ClientInfo.CLIENT_SECRET, context)
    private val clientCredentialsFlow: ClientCredentialsFlow = ClientCredentialsFlow(tokenFetcher)

    @Test
    fun fetchAccessToken() {
        Assert.assertTrue(
                clientCredentialsFlow.fetchAccessToken()
                        .get(10, TimeUnit.SECONDS)
                        .has("access_token"))
    }
}