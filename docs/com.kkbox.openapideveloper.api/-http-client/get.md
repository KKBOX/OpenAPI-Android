---
title: HttpClient.get - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [HttpClient](index.html) / [get](.)

# get

`fun get(endpoint: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, params: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?> = emptyMap()): ResponseFuture<JsonObject>`

Get the result from the passed in url.

### Parameters

`endpoint` - The api endpoint

`params` - The query part of the url

**Return**
the Future object that will return the http response

