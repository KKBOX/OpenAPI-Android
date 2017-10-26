---
title: SharedPlaylistFetcher.fetchTracks - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [SharedPlaylistFetcher](index.html) / [fetchTracks](.)

# fetchTracks

`fun fetchTracks(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`

Fetch track list of a playlist by given ID.

``` kotlin
this.playlistId = playlistId
return this
```

### Parameters

`limit` - The size for one page.

`offset` - The offset index for first element.

**Return**
the API response.

