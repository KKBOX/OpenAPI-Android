package com.kkbox.openapideveloper.auth

import android.content.Context

/**
 * The instance of this class fetches the authorization.
 *
 * @property clientID the client ID for accessing kkbox open api.
 * @property clientSecret the client secret for accessing kkbox open api.
 * @property context the context needed for creating http connection.
 */
class Auth(clientID: String, clientSecret: String, context: Context) {
    val tokenFetcher = TokenFetcher(clientID, clientSecret, context)
    val clientCredentialsFlow = ClientCredentialsFlow(tokenFetcher)
}