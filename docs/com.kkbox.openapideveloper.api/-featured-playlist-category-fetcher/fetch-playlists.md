---
title: FeaturedPlaylistCategoryFetcher.fetchPlaylists - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [FeaturedPlaylistCategoryFetcher](index.html) / [fetchPlaylists](.)

# fetchPlaylists

`fun fetchPlaylists(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`

Fetch featured playlists of the category with the category fetcher you init. Result will be paged.

``` kotlin
this.categoryId = categoryId
return this
```

### Parameters

`limit` - The size of one page.

`offset` - The offset index for first element.

**Return**
playlists of the category.

