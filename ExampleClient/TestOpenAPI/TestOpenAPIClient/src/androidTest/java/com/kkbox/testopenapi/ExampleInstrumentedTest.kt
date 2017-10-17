package com.kkbox.testopenapi

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log

import com.google.gson.JsonObject
import com.kkbox.openapi.TokenFetcher
import com.koushikdutta.async.future.Future

import org.junit.Test
import org.junit.runner.RunWith

import java.util.concurrent.TimeUnit

import org.junit.Assert.*

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()

        assertEquals("com.kkbox.testopenapi", appContext.packageName)
    }
}
