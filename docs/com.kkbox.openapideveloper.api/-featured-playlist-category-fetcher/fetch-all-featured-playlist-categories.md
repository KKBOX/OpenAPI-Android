---
title: FeaturedPlaylistCategoryFetcher.fetchAllFeaturedPlaylistCategories - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [FeaturedPlaylistCategoryFetcher](index.html) / [fetchAllFeaturedPlaylistCategories](.)

# fetchAllFeaturedPlaylistCategories

`fun fetchAllFeaturedPlaylistCategories(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`

Fetch all featured playlist categories.

``` kotlin
return httpClient.get(endpoint,
        mapOf("territory" to territory,
                "limit" to limit?.toString(),
                "offset" to offset?.toString()))
```

**Return**
all featured playlist categories.

