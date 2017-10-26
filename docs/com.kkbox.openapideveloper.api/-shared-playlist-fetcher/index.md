---
title: SharedPlaylistFetcher - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [SharedPlaylistFetcher](.)

# SharedPlaylistFetcher

`class SharedPlaylistFetcher`

Fetch metadata and tracks of a specific shared playlist.

### Constructors

| [&lt;init&gt;](-init-.html) | `SharedPlaylistFetcher(httpClient: `[`HttpClient`](../-http-client/index.html)`, territory: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "TW")`<br>Creates a shared playlist fetcher. |

### Properties

| [playlistId](playlist-id.html) | `lateinit var playlistId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| [fetchMetadata](fetch-metadata.html) | `fun fetchMetadata(): ResponseFuture<JsonObject>`<br>Fetch the shared playlist by given ID. |
| [fetchTracks](fetch-tracks.html) | `fun fetchTracks(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`<br>Fetch track list of a playlist by given ID. |
| [getWidgetUri](get-widget-uri.html) | `fun getWidgetUri(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Get the widget url of the album. |
| [setPlaylistId](set-playlist-id.html) | `fun setPlaylistId(playlistId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): SharedPlaylistFetcher`<br>Set the shared playlist ID. |

