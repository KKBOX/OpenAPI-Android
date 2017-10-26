---
title: TrackFetcher - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [TrackFetcher](.)

# TrackFetcher

`class TrackFetcher`

Fetch metadata of a track.

### Constructors

| [&lt;init&gt;](-init-.html) | `TrackFetcher(httpClient: `[`HttpClient`](../-http-client/index.html)`, territory: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "TW")`<br>Creates a track fetcher. |

### Properties

| [trackId](track-id.html) | `lateinit var trackId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| [fetchMetadata](fetch-metadata.html) | `fun fetchMetadata(): ResponseFuture<JsonObject>`<br>Fetch metadata of a track by given ID. |
| [getWidgetUri](get-widget-uri.html) | `fun getWidgetUri(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Get the widget url of the track. |
| [setTrackId](set-track-id.html) | `fun setTrackId(trackId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): TrackFetcher`<br>Set the track ID. |

