package com.kkbox.openapideveloper.auth

import com.google.gson.JsonObject
import com.koushikdutta.ion.future.ResponseFuture

/**
 * Implements the client credentials flow. Used for accessing APIs that don't need any KKBOX user's personal data.
 *
 * @property tokenFetcher
 * @see `https://docs.kkbox.codes/docs/client-credentials-flow`
 */
class ClientCredentialsFlow(private val tokenFetcher: TokenFetcher) {
    /**
     * Fetch access token.
     *
     * @return the access token.
     * @sample ClientCredentialsFlow.fetchAccessToken()
     */
    fun fetchAccessToken(): ResponseFuture<JsonObject> {
        return tokenFetcher.fetchAccessToken(mapOf("grant_type" to listOf("client_credentials")))
    }
}