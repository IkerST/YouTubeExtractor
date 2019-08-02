package com.commit451.youtubeextractor

import com.squareup.moshi.Json

internal class PlayerArgs {

    @field:Json(name = "url_encoded_fmt_stream_map")
    var urlEncodedFmtStreamMap: String? = null
    @field:Json(name = "adaptive_fmts")
    var adaptiveFmt: String? = null
    @field:Json(name = "player_response")
    var playerResponse: String?  = null


}

