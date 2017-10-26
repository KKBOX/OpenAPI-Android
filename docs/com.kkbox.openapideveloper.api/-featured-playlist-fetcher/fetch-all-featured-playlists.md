---
title: FeaturedPlaylistFetcher.fetchAllFeaturedPlaylists - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [FeaturedPlaylistFetcher](index.html) / [fetchAllFeaturedPlaylists](.)

# fetchAllFeaturedPlaylists

`fun fetchAllFeaturedPlaylists(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`

Fetch featured playlists.

``` kotlin
return httpClient.get(endpoint,
        mapOf("territory" to territory,
                "limit" to limit?.toString(),
                "offset" to offset?.toString()))
```

### Parameters

`limit` - The size for one page.

`offset` - The offset index for first element.

**Return**
the API response.

