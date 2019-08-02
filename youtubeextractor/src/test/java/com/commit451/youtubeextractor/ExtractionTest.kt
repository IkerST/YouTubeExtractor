package com.commit451.youtubeextractor

import org.junit.Assert
import org.junit.Test

class ExtractionTest {

    companion object {
        private const val YOUTUBE_ID = "vuof6VpZUAs"
        private const val YOUTUBE_ID_REQUIRES_SIGNATURE = "OuFSuqLHe58"

    }

    @Test
    fun testExtraction() {
        val extractor = YouTubeExtractor.Builder()
                .debug(true)
                .build()
        val startTime = System.currentTimeMillis()
        val result = extractor.extract(YOUTUBE_ID)
                .blockingGet()
        println("Time taken: ${System.currentTimeMillis() - startTime}")
        testResult(result)
    }

    @Test
    fun testExtractionWithSignature() {
        val extractor = YouTubeExtractor.Builder()
                .debug(true)
                .build()
        val startTime = System.currentTimeMillis()
        val result = extractor.extract(YOUTUBE_ID_REQUIRES_SIGNATURE)
                .blockingGet()
        println("Time taken: ${System.currentTimeMillis() - startTime}")
        testResult(result)
    }

        @Test
    fun testExtractionAudioOnly() {
        val extractor = YouTubeExtractor.Builder()
                .debug(true)
                .build()
        val startTime = System.currentTimeMillis()
        val result = extractor.extract(YOUTUBE_ID, true)
                .blockingGet()
        println("Time taken: ${System.currentTimeMillis() - startTime}")
        testResult(result)
    }

    private fun testResult(extraction: YouTubeExtraction) {
        Assert.assertTrue(extraction.streams.isNotEmpty())
        Assert.assertTrue(extraction.thumbnails.isNotEmpty())
        Assert.assertNotNull(extraction.title)
        Assert.assertNotNull(extraction.description)
        Assert.assertNotNull(extraction.lengthSeconds)
        Assert.assertNotNull(extraction.viewCount)
        Assert.assertNotNull(extraction.author)
        
    }
}
