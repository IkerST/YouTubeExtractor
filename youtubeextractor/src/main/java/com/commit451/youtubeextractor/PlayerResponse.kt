    
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
    }