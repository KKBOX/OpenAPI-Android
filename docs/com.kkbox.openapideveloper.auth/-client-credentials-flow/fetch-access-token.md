---
title: ClientCredentialsFlow.fetchAccessToken - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.auth](../index.html) / [ClientCredentialsFlow](index.html) / [fetchAccessToken](.)

# fetchAccessToken

`fun fetchAccessToken(): ResponseFuture<JsonObject>`

Fetch access token.

``` kotlin
return tokenFetcher.fetchAccessToken(mapOf("grant_type" to listOf("client_credentials")))
```

**Return**
the access token.

