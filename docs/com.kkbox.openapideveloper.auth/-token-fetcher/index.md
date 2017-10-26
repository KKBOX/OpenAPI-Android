---
title: TokenFetcher - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.auth](../index.html) / [TokenFetcher](.)

# TokenFetcher

`class TokenFetcher`

The instance of this class fetches open api token.

### Constructors

| [&lt;init&gt;](-init-.html) | `TokenFetcher(clientID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, clientSecret: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`<br>creates a token fetcher. |

### Properties

| [clientID](client-i-d.html) | `val clientID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>the client ID for accessing kkbox open api. |
| [clientSecret](client-secret.html) | `val clientSecret: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>the client secret for accessing kkbox open api. |
| [context](context.html) | `val context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)<br>the context needed for creating http connection. |

### Functions

| [fetchAccessToken](fetch-access-token.html) | `fun fetchAccessToken(bodyParameters: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>>): ResponseFuture<JsonObject>`<br>Fetches the access token. |
| [fetchInfo](fetch-info.html) | `fun fetchInfo(accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): ResponseFuture<JsonObject>`<br>Fetches information about a access token. |
| [refresh](refresh.html) | `fun refresh(refreshToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): ResponseFuture<JsonObject>`<br>Refresh token when the token expired. |

