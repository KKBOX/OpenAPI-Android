---
title: SearchFetcher - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [SearchFetcher](.)

# SearchFetcher

`class SearchFetcher`

Search API, the types it can search includes artists, albums, tracks, or playlists.
Default to search all types, use "," to separate types if you want to use multiple
types to search at the same time.

### Constructors

| [&lt;init&gt;](-init-.html) | `SearchFetcher(httpClient: `[`HttpClient`](../-http-client/index.html)`, territory: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "TW")`<br>Search API, the types it can search includes artists, albums, tracks, or playlists. Default to search all types, use "," to separate types if you want to use multiple types to search at the same time. |

### Properties

| [q](q.html) | `lateinit var q: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [type](type.html) | `var type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |

### Functions

| [fetchSearchResult](fetch-search-result.html) | `fun fetchSearchResult(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`<br>Fetch the search result. |
| [setSearchCriteria](set-search-criteria.html) | `fun setSearchCriteria(q: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null): SearchFetcher`<br>Search within KKBOX's database. |

