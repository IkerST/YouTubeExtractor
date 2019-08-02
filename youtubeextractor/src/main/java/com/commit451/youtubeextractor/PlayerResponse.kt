    
package com.commit451.youtubeextractor

import com.squareup.moshi.Json

class PlayerResponse {
    @field:Json(name = "videoDetails")
    var videoDetails: VideoDetails? = null

    class VideoDetails{
        @field:Json(name = "title")
        var title: String? = null

        @field:Json(name = "author")
        var author: String? = null

        @field:Json(name = "shortDescription")
        var shortDescription: String? = null

        @field:Json(name = "lengthSeconds")
        var lengthSeconds: Long? = null

        @field:Json(name = "viewCount")
        var viewCount: Long? = null
    }

    @field:Json(name = "streamingData")
    var streamingData: StreamingData? = null

    class StreamingData {
        @field:Json(name = "adaptiveFormats")
        var adaptiveFormats: List<AdaptiveFormats>? = null

        @field:Json(name = "formats")
        var formats: List<AdaptiveFormats>? = null
    }
}

data class AdaptiveFormats(
    @field:Json(name = "itag")
    var itag: Long? = null,
    
    @field:Json(name = "bitrate")
    var bitrate: Long? = null,

    @field:Json(name = "qualityLabel")
    var qualityLabels: String? = null,

    @field:Json(name = "contentLength")
    var contentLength: Long? = null,

    @field:Json(name = "cipher")
    var cipher: String? = null
)