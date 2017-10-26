---
title: TokenFetcher.fetchInfo - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.auth](../index.html) / [TokenFetcher](index.html) / [fetchInfo](.)

# fetchInfo

`fun fetchInfo(accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): ResponseFuture<JsonObject>`

Fetches information about a access token.

``` kotlin
return Ion.with(context)
        .load(Endpoint.Auth.TOKEN_INFO.uri+"?access_token=$accessToken")
        .setHeader("User-Agent", "KKBOX Openapi Android SDK")
        .asJsonObject()
```

### Parameters

`accessToken` - Access token authorized by a user, need to be URL encoded before using.

**Return**
the token info object.

