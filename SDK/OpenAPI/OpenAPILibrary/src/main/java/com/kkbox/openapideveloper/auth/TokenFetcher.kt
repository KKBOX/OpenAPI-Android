package com.kkbox.openapideveloper.auth

import android.content.Context
import com.google.gson.JsonObject
import com.kkbox.openapideveloper.Endpoint
import com.koushikdutta.ion.Ion
import com.koushikdutta.ion.future.ResponseFuture

/**
 * The instance of this class fetches open api token.
 *
 * @property clientID the client ID for accessing kkbox open api.
 * @property clientSecret the client secret for accessing kkbox open api.
 * @property context the context needed for creating http connection.
 * @constructor creates a token fetcher.
 */
class TokenFetcher(val clientID: String, val clientSecret: String, val context: Context) {
    /**
     * Fetches information about a access token.
     *
     * @param accessToken Access token authorized by a user, need to be URL encoded before using.
     * @return the token info object.
     * @sample TokenFetcher.fetchInfo('1DOOqXertxd9nUs0MOHQSA==')
     * @see `https://docs.kkbox.codes/docs/token-introspection-api`
     */
    fun fetchInfo(accessToken: String): ResponseFuture<JsonObject> {
        return Ion.with(context)
                .load(Endpoint.Auth.TOKEN_INFO.uri+"?access_token=$accessToken")
                .setHeader("User-Agent", "KKBOX Openapi Android SDK")
                .asJsonObject()
    }

    /**
     * Fetches the access token.
     *
     * @return the Future object that will return the token api response.
     */
    fun fetchAccessToken(bodyParameters: Map<String, List<String>>): ResponseFuture<JsonObject> {
        return Ion.with(context)
                .load(Endpoint.Auth.TOKEN.uri)
                .basicAuthentication(clientID, clientSecret)
                .setHeader("User-Agent", "KKBOX Android SDK")
                .setBodyParameters(bodyParameters)
                .asJsonObject()
    }

    /**
     * Refresh token when the token expired.
     *
     * @param refreshToken The refresh token you retrieved before.
     * @return the refresh token.
     * @sample TokenFetcher.refresh('OYIWwu8+kP3H2I7jvQBVJw==')
     * @see `https://docs.kkbox.codes/docs/oauth2-token-api-refresh-token`
     */
    fun refresh(refreshToken: String): ResponseFuture<JsonObject> {
        return this.fetchAccessToken(
                mapOf("grant_type" to listOf("refresh_token"),
                        "refresh_token" to listOf(refreshToken)))
    }
}
