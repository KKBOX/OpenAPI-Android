---
title: NewHitsPlaylistFetcher - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [NewHitsPlaylistFetcher](.)

# NewHitsPlaylistFetcher

`class NewHitsPlaylistFetcher`

List all new hits playlists and fetch tracks for specific new hit playlist.

### Constructors

| [&lt;init&gt;](-init-.html) | `NewHitsPlaylistFetcher(httpClient: `[`HttpClient`](../-http-client/index.html)`, territory: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "TW")`<br>Creates a new hits playlist fetcher. |

### Properties

| [playlistId](playlist-id.html) | `lateinit var playlistId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| [fetchAllNewHitsPlaylists](fetch-all-new-hits-playlists.html) | `fun fetchAllNewHitsPlaylists(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`<br>Fetch all new hits playlists. |
| [fetchMetadata](fetch-metadata.html) | `fun fetchMetadata(): ResponseFuture<JsonObject>`<br>Fetch new hits playlist by given ID. |
| [setPlaylistId](set-playlist-id.html) | `fun setPlaylistId(playlistId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): NewHitsPlaylistFetcher`<br>Set the new hits playlist ID. |

