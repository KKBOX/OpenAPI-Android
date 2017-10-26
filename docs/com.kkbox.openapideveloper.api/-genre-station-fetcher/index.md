---
title: GenreStationFetcher - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [GenreStationFetcher](.)

# GenreStationFetcher

`class GenreStationFetcher`

Fetch genre stations and get tracks for a specific genre station.

### Constructors

| [&lt;init&gt;](-init-.html) | `GenreStationFetcher(httpClient: `[`HttpClient`](../-http-client/index.html)`, territory: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "TW")`<br>Creates a genre station fetcher. |

### Properties

| [genreStationId](genre-station-id.html) | `lateinit var genreStationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| [fetchAllGenreStations](fetch-all-genre-stations.html) | `fun fetchAllGenreStations(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`<br>Fetch all genre stations. |
| [fetchMetadata](fetch-metadata.html) | `fun fetchMetadata(): ResponseFuture<JsonObject>`<br>Fetch metadata of a genre station by given ID. |
| [setGenreStationId](set-genre-station-id.html) | `fun setGenreStationId(genreStationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): GenreStationFetcher`<br>Set a genre station ID. |

