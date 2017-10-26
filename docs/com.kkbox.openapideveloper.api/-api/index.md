---
title: Api - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [Api](.)

# Api

`class Api`

Fetch KKBOX resources.

### Parameters

`accessToken` - Get via Auth.

`territory` - [TW,HK,SG,MY,JP](#) The territory for the fetcher.

### Constructors

| [&lt;init&gt;](-init-.html) | `Api(accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, territory: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "TW", context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`<br>need access token to initialize. |

### Properties

| [albumFetcher](album-fetcher.html) | `val albumFetcher: `[`AlbumFetcher`](../-album-fetcher/index.html) |
| [artistFetcher](artist-fetcher.html) | `val artistFetcher: `[`ArtistFetcher`](../-artist-fetcher/index.html) |
| [chartFetcher](chart-fetcher.html) | `val chartFetcher: `[`ChartFetcher`](../-chart-fetcher/index.html) |
| [featuredPlaylistCategoryFetcher](featured-playlist-category-fetcher.html) | `val featuredPlaylistCategoryFetcher: `[`FeaturedPlaylistCategoryFetcher`](../-featured-playlist-category-fetcher/index.html) |
| [featuredPlaylistFetcher](featured-playlist-fetcher.html) | `val featuredPlaylistFetcher: `[`FeaturedPlaylistFetcher`](../-featured-playlist-fetcher/index.html) |
| [genreStationFetcher](genre-station-fetcher.html) | `val genreStationFetcher: `[`GenreStationFetcher`](../-genre-station-fetcher/index.html) |
| [hitsPlaylistFetcher](hits-playlist-fetcher.html) | `val hitsPlaylistFetcher: `[`NewHitsPlaylistFetcher`](../-new-hits-playlist-fetcher/index.html) |
| [moodStationFetcher](mood-station-fetcher.html) | `val moodStationFetcher: `[`MoodStationFetcher`](../-mood-station-fetcher/index.html) |
| [releaseCategoryFetcher](release-category-fetcher.html) | `val releaseCategoryFetcher: `[`NewReleaseCategoryFetcher`](../-new-release-category-fetcher/index.html) |
| [searchFetcher](search-fetcher.html) | `val searchFetcher: `[`SearchFetcher`](../-search-fetcher/index.html) |
| [trackFetcher](track-fetcher.html) | `val trackFetcher: `[`TrackFetcher`](../-track-fetcher/index.html) |

