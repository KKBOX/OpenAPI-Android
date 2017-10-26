---
title: FeaturedPlaylistCategoryFetcher - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [FeaturedPlaylistCategoryFetcher](.)

# FeaturedPlaylistCategoryFetcher

`class FeaturedPlaylistCategoryFetcher`

List featured playlist categories.

### Constructors

| [&lt;init&gt;](-init-.html) | `FeaturedPlaylistCategoryFetcher(httpClient: `[`HttpClient`](../-http-client/index.html)`, territory: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "TW")`<br>List featured playlist categories. |

### Properties

| [categoryId](category-id.html) | `lateinit var categoryId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| [fetchAllFeaturedPlaylistCategories](fetch-all-featured-playlist-categories.html) | `fun fetchAllFeaturedPlaylistCategories(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`<br>Fetch all featured playlist categories. |
| [fetchMetadata](fetch-metadata.html) | `fun fetchMetadata(): ResponseFuture<JsonObject>`<br>Fetch metadata of the category you init. |
| [fetchPlaylists](fetch-playlists.html) | `fun fetchPlaylists(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`<br>Fetch featured playlists of the category with the category fetcher you init. Result will be paged. |
| [setCategoryId](set-category-id.html) | `fun setCategoryId(categoryId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): FeaturedPlaylistCategoryFetcher`<br>Init the featured playlist category fetcher. |

