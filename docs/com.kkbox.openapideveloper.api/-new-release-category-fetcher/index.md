---
title: NewReleaseCategoryFetcher - com.kkbox.openapideveloper
---

[com.kkbox.openapideveloper](../../index.html) / [com.kkbox.openapideveloper.api](../index.html) / [NewReleaseCategoryFetcher](.)

# NewReleaseCategoryFetcher

`class NewReleaseCategoryFetcher`

List categories of new release category and get metadata of specific new release category.

### Constructors

| [&lt;init&gt;](-init-.html) | `NewReleaseCategoryFetcher(httpClient: `[`HttpClient`](../-http-client/index.html)`, territory: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "TW")`<br>Creates a new release category fetcher. |

### Properties

| [categoryId](category-id.html) | `lateinit var categoryId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| [fetchAlbums](fetch-albums.html) | `fun fetchAlbums(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`<br>Fetch albums of new release category by given ID |
| [fetchAllNewReleaseCategories](fetch-all-new-release-categories.html) | `fun fetchAllNewReleaseCategories(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): ResponseFuture<JsonObject>`<br>Fetch all new release categories. |
| [fetchMetadata](fetch-metadata.html) | `fun fetchMetadata(): ResponseFuture<JsonObject>`<br>Fetch new release category by given ID. |
| [setCategoryId](set-category-id.html) | `fun setCategoryId(categoryId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): NewReleaseCategoryFetcher`<br>Set the category ID |

