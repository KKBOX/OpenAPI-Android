---
title: SearchFetcher.fetchSearchResult - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [SearchFetcher](index.html) / [fetchSearchResult](.)

# fetchSearchResult

`fun fetchSearchResult(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`

Fetch the search result.

``` kotlin
this.q = q
this.type = type
return this
```

### Parameters

`limit` - The size for one page.

`offset` - The offset index for first element.

**Return**
the API response.

