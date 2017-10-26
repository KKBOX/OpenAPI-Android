---
title: ArtistFetcher - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [ArtistFetcher](.)

# ArtistFetcher

`class ArtistFetcher`

Get artist metadata.

### Constructors

| [&lt;init&gt;](-init-.html) | `ArtistFetcher(httpClient: `[`HttpClient`](../-http-client/index.html)`, territory: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "TW")`<br>Creates an artist fetcher. |

### Properties

| [artistId](artist-id.html) | `lateinit var artistId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| [fetchAlbums](fetch-albums.html) | `fun fetchAlbums(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`<br>Fetch albums belong to an artist. |
| [fetchMetadata](fetch-metadata.html) | `fun fetchMetadata(): ResponseFuture<JsonObject>`<br>Fetches metadata of an artist. |
| [fetchTopTracks](fetch-top-tracks.html) | `fun fetchTopTracks(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`<br>Fetch top tracks belong to an artist. |
| [setArtistId](set-artist-id.html) | `fun setArtistId(artistId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): ArtistFetcher`<br>Init the artist object. |

