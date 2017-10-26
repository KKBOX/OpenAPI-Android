---
title: MoodStationFetcher - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [MoodStationFetcher](.)

# MoodStationFetcher

`class MoodStationFetcher`

Fetch mood stations and get tracks for a specific mood station.

### Constructors

| [&lt;init&gt;](-init-.html) | `MoodStationFetcher(httpClient: `[`HttpClient`](../-http-client/index.html)`, territory: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "TW")`<br>Creates a mood station fetcher. |

### Properties

| [moodStationId](mood-station-id.html) | `lateinit var moodStationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| [fetchAllMoodStations](fetch-all-mood-stations.html) | `fun fetchAllMoodStations(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`<br>Fetch all mood stations. |
| [fetchMetadata](fetch-metadata.html) | `fun fetchMetadata(): ResponseFuture<JsonObject>`<br>Fetch metadata of a mood station by given ID. |
| [setMoodStationId](set-mood-station-id.html) | `fun setMoodStationId(moodStationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): MoodStationFetcher`<br>Set a mood station ID. |

