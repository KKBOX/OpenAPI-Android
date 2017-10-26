---
title: HttpClient - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [HttpClient](.)

# HttpClient

`class HttpClient`

The http client instance will get response from specific url.

### Constructors

| [&lt;init&gt;](-init-.html) | `HttpClient(token: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`<br>Creates a http client instance |

### Functions

| [get](get.html) | `fun get(endpoint: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, params: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?> = emptyMap()): ResponseFuture<JsonObject>`<br>Get the result from the passed in url. |
| [post](post.html) | `fun post(endpoint: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, data: JsonObject): ResponseFuture<JsonObject>`<br>Http post method. |

