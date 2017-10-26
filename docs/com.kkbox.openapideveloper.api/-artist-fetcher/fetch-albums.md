---
title: ArtistFetcher.fetchAlbums - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [ArtistFetcher](index.html) / [fetchAlbums](.)

# fetchAlbums

`fun fetchAlbums(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`

Fetch albums belong to an artist.

``` kotlin
this.artistId = artistId
return this
```

### Parameters

`limit` - the size for one page.

`offset` - the offset index for first element.

**Return**
albums belong to the Artist.

