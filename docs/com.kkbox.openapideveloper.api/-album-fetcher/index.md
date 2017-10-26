---
title: AlbumFetcher - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [AlbumFetcher](.)

# AlbumFetcher

`class AlbumFetcher`

Get metadata and tracks of an album.

### Constructors

| [&lt;init&gt;](-init-.html) | `AlbumFetcher(httpClient: `[`HttpClient`](../-http-client/index.html)`, territory: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "TW")`<br>Creates an album fetcher. |

### Properties

| [albumId](album-id.html) | `lateinit var albumId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| [fetchMetadata](fetch-metadata.html) | `fun fetchMetadata(): ResponseFuture<JsonObject>`<br>Fetches metadata of an album by given ID. |
| [fetchTracks](fetch-tracks.html) | `fun fetchTracks(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`<br>Fetches tracks in an album by given ID. |
| [getWidgetUri](get-widget-uri.html) | `fun getWidgetUri(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Get the widget url of the album. |
| [setAlbumId](set-album-id.html) | `fun setAlbumId(albumId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): AlbumFetcher`<br>Set the album ID. |

