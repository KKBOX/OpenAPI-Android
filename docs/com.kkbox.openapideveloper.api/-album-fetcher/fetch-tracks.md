---
title: AlbumFetcher.fetchTracks - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [AlbumFetcher](index.html) / [fetchTracks](.)

# fetchTracks

`fun fetchTracks(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`

Fetches tracks in an album by given ID.

``` kotlin
this.albumId = albumId
return this
```

### Parameters

`limit` - The size for one page.

`offset` - The offset index for first element.

**Return**
tracks of the album.

