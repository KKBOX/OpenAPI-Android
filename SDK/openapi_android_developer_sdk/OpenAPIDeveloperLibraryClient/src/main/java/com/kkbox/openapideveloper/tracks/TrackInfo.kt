package com.kkbox.openapideveloper.tracks

/**
 * Created by sharonyang on 2017/9/26.
 */

class TrackInfo {
    var name: String = ""
    var artist: String = ""
    var albumImage: String = ""

    constructor() {}

    constructor(name: String, artist: String, albumImage: String) {
        this.name = name
        this.artist = artist
        this.albumImage = albumImage
    }
}