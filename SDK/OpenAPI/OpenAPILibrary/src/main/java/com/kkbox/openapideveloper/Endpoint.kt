package com.kkbox.openapideveloper

val OAuth_DOMAIN = "https://account.kkbox.com/oauth2"
val API_DOMAIN = "https://api.kkbox.com/v1.1"

/**
 * API Endpoint.
 */
class Endpoint {
    enum class API(val uri: String) {
        SEARCH(API_DOMAIN + "/search"),
        TRACKS(API_DOMAIN + "/tracks"),
        ARTISTS(API_DOMAIN + "/artists"),
        ALBUMS(API_DOMAIN + "/albums"),
        SHARED_PLAYLISTS(API_DOMAIN + "/shared-playlists"),
        MOOD_STATIONS(API_DOMAIN + "/mood-stations"),
        FEATURED_PLAYLISTS(API_DOMAIN + "/featured-playlists"),
        FEATURED_PLAYLISTS_CATEGORIES(API_DOMAIN + "/featured-playlist-categories"),
        NEW_RELEASE_CATEGORIES(API_DOMAIN + "/new-release-categories"),
        NEW_HITS_PLAYLISTS(API_DOMAIN + "/new-hits-playlists"),
        GENRE_STATIONS(API_DOMAIN + "/genre-stations"),
        CHARTS(API_DOMAIN + "/charts"),
        TICKETS(API_DOMAIN + "/tickets"),
        USERS(API_DOMAIN + "/users"),
        ME(API_DOMAIN + "/me"),
        PLAYLISTS(API_DOMAIN + "/me/playlists");

        enum class SearchType
    }

    enum class Auth(val uri: String) {
        TOKEN(OAuth_DOMAIN + "/token"),
        TOKEN_INFO(OAuth_DOMAIN + "/tokeninfo"),
        Authorization(OAuth_DOMAIN + "/authorize"),
        DeviceCode(OAuth_DOMAIN + "/device/code"),
        GenerateQRCode("https://qrcode.kkbox.com.tw/generator")
    }
}