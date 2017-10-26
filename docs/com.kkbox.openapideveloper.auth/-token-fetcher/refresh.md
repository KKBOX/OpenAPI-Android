---
title: TokenFetcher.refresh - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.auth](../index.html) / [TokenFetcher](index.html) / [refresh](.)

# refresh

`fun refresh(refreshToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): ResponseFuture<JsonObject>`

Refresh token when the token expired.

``` kotlin
return this.fetchAccessToken(
        mapOf("grant_type" to listOf("refresh_token"),
                "refresh_token" to listOf(refreshToken)))
```

### Parameters

`refreshToken` - The refresh token you retrieved before.

**Return**
the refresh token.

