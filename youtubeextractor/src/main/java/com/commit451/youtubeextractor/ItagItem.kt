package com.commit451.youtubeextractor

internal class ItagItem(val id: Int, val format: String, val resolution: String, var filesize: Long? = null) {

    companion object {

        /**
         * List can be found here https://github.com/rg3/youtube-dl/blob/master/youtube_dl/extractor/youtube.py#L360
         */
        private val ITAG_MAP = mapOf(

                17 to ItagItem(17, Streams.FORMAT_v3GPP, Streams.RESOLUTION_144p),

                18 to ItagItem(18, Streams.FORMAT_MPEG_4, Streams.RESOLUTION_360p),
                34 to ItagItem(34, Streams.FORMAT_MPEG_4, Streams.RESOLUTION_360p),
                35 to ItagItem(35, Streams.FORMAT_MPEG_4, Streams.RESOLUTION_480p),
                36 to ItagItem(36, Streams.FORMAT_v3GPP, Streams.RESOLUTION_240p),
                59 to ItagItem(59, Streams.FORMAT_MPEG_4, Streams.RESOLUTION_480p),
                78 to ItagItem(78, Streams.FORMAT_MPEG_4, Streams.RESOLUTION_480p),
                22 to ItagItem(22, Streams.FORMAT_MPEG_4, Streams.RESOLUTION_720p),
                37 to ItagItem(37, Streams.FORMAT_MPEG_4, Streams.RESOLUTION_1080p),
                38 to ItagItem(38, Streams.FORMAT_MPEG_4, Streams.RESOLUTION_1080p),

                43 to ItagItem(43, Streams.FORMAT_WEBM, Streams.RESOLUTION_360p),
                44 to ItagItem(44, Streams.FORMAT_WEBM, Streams.RESOLUTION_480p),
                45 to ItagItem(45, Streams.FORMAT_WEBM, Streams.RESOLUTION_720p),
                46 to ItagItem(46, Streams.FORMAT_WEBM, Streams.RESOLUTION_1080p),

                160 to ItagItem(160, Streams.FORMAT_MPEG_4, Streams.RESOLUTION_144p),
                133 to ItagItem(133, Streams.FORMAT_MPEG_4, Streams.RESOLUTION_240p),
                134 to ItagItem(134, Streams.FORMAT_MPEG_4, Streams.RESOLUTION_360p),
                135 to ItagItem(135, Streams.FORMAT_MPEG_4, Streams.RESOLUTION_480p),
                212 to ItagItem(212, Streams.FORMAT_MPEG_4, Streams.RESOLUTION_480p),
                136 to ItagItem(136, Streams.FORMAT_MPEG_4, Streams.RESOLUTION_720p),
                298 to ItagItem(298, Streams.FORMAT_MPEG_4, Streams.RESOLUTION_720p60),
                137 to ItagItem(137, Streams.FORMAT_MPEG_4, Streams.RESOLUTION_1080p),
                299 to ItagItem(299, Streams.FORMAT_MPEG_4, Streams.RESOLUTION_1080p60),
                266 to ItagItem(266, Streams.FORMAT_MPEG_4, Streams.RESOLUTION_2160p),

                278 to ItagItem(278, Streams.FORMAT_WEBM, Streams.RESOLUTION_144p),
                242 to ItagItem(242, Streams.FORMAT_WEBM, Streams.RESOLUTION_240p),
                243 to ItagItem(243, Streams.FORMAT_WEBM, Streams.RESOLUTION_360p),
                244 to ItagItem(244, Streams.FORMAT_WEBM, Streams.RESOLUTION_480p),
                245 to ItagItem(245, Streams.FORMAT_WEBM, Streams.RESOLUTION_480p),
                246 to ItagItem(246, Streams.FORMAT_WEBM, Streams.RESOLUTION_480p),
                247 to ItagItem(247, Streams.FORMAT_WEBM, Streams.RESOLUTION_720p),
                248 to ItagItem(248, Streams.FORMAT_WEBM, Streams.RESOLUTION_1080p),
                271 to ItagItem(271, Streams.FORMAT_WEBM, Streams.RESOLUTION_1440p),
                272 to ItagItem(272, Streams.FORMAT_WEBM, Streams.RESOLUTION_2160p),
                302 to ItagItem(302, Streams.FORMAT_WEBM, Streams.RESOLUTION_720p60),
                303 to ItagItem(303, Streams.FORMAT_WEBM, Streams.RESOLUTION_1080p60),
                308 to ItagItem(308, Streams.FORMAT_WEBM, Streams.RESOLUTION_1440p60),
                313 to ItagItem(313, Streams.FORMAT_WEBM, Streams.RESOLUTION_2160p),
                315 to ItagItem(315, Streams.FORMAT_WEBM, Streams.RESOLUTION_2160p60),

                139 to ItagItem(139, Streams.FORMAT_M4A, Streams.RESOLUTION_AUDIO),
                140 to ItagItem(140, Streams.FORMAT_M4A, Streams.RESOLUTION_AUDIO),
                141 to ItagItem(141, Streams.FORMAT_M4A, Streams.RESOLUTION_AUDIO),
                256 to ItagItem(256, Streams.FORMAT_M4A, Streams.RESOLUTION_AUDIO),
                258 to ItagItem(258, Streams.FORMAT_M4A, Streams.RESOLUTION_AUDIO),
                325 to ItagItem(325, Streams.FORMAT_M4A, Streams.RESOLUTION_AUDIO),
                328 to ItagItem(328, Streams.FORMAT_M4A, Streams.RESOLUTION_AUDIO),

                171 to ItagItem(171, Streams.FORMAT_WEBM, Streams.RESOLUTION_AUDIO),
                172 to ItagItem(172, Streams.FORMAT_WEBM, Streams.RESOLUTION_AUDIO),
                249 to ItagItem(249, Streams.FORMAT_WEBM, Streams.RESOLUTION_AUDIO),
                250 to ItagItem(250, Streams.FORMAT_WEBM, Streams.RESOLUTION_AUDIO),
                251 to ItagItem(251, Streams.FORMAT_WEBM, Streams.RESOLUTION_AUDIO)
        )


        fun isSupported(itag: Int?): Boolean {
            return ITAG_MAP.containsKey(itag)
        }

        fun isAudio(itag:Int?): Boolean {
            return ITAG_MAP.get(itag)?.resolution == "AUDIO"
        }

        fun getItag(itagId: Int?): ItagItem {
            return ITAG_MAP[itagId] ?: throw YouTubeExtractionException("itag=$itagId not supported")
        }
    }
}