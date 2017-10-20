package com.kkbox.openapideveloper.api

import android.content.Context

/**
 * Fetch KKBOX resources.
 *
 * @param accessToken Get via Auth.
 * @param territory ['TW', 'HK', 'SG', 'MY', 'JP'] The territory for the fetcher.
 * @constructor need access token to initialize.
 * @sample Api(accessToken)
 */
class Api(private val accessToken: String, private val territory: String = "TW", context: Context) {
    private val httpClient: HttpClient = HttpClient(accessToken, context)
    val searchFetcher: SearchFetcher = SearchFetcher(httpClient, territory)
    val trackFetcher: TrackFetcher = TrackFetcher(httpClient, territory)
    val albumFetcher: AlbumFetcher = AlbumFetcher(httpClient, territory)
    val artistFetcher: ArtistFetcher = ArtistFetcher(httpClient, territory)
    val featuredPlaylistFetcher: FeaturedPlaylistFetcher = FeaturedPlaylistFetcher(httpClient, territory)
    val featuredPlaylistCategoryFetcher: FeaturedPlaylistCategoryFetcher = FeaturedPlaylistCategoryFetcher(httpClient, territory)
    val releaseCategoryFetcher: NewReleaseCategoryFetcher = NewReleaseCategoryFetcher(httpClient, territory)
    val hitsPlaylistFetcher: NewHitsPlaylistFetcher = NewHitsPlaylistFetcher(httpClient, territory)
    val genreStationFetcher: GenreStationFetcher = GenreStationFetcher(httpClient, territory)
    val moodStationFetcher: MoodStationFetcher = MoodStationFetcher(httpClient, territory)
    val chartFetcher: ChartFetcher = ChartFetcher(httpClient, territory)
}