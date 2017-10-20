package com.kkbox.openapidevelopertest.auth

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import com.kkbox.openapideveloper.ClientInfo
import com.kkbox.openapideveloper.auth.Auth
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class AuthTest {
    private val context = InstrumentationRegistry.getTargetContext()
    private val auth = Auth(ClientInfo.CLIENT_ID, ClientInfo.CLIENT_SECRET, context)

    /*
    @Test
    fun testTokenFetcher() {
        auth.tokenFetcher
    }
    */

    @Test
    fun testClientCredentialsFlow() {
        val responseFuture = auth.clientCredentialsFlow.fetchAccessToken()
        try {
            val `object` = responseFuture.get(10, TimeUnit.SECONDS)
            Assert.assertTrue(`object`.get("access_token").asString.isNotEmpty())
        } catch (e: Exception) {
            Log.d("ERROR", e.toString())
        }

    }
}
