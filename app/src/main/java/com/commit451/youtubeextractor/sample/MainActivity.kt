package com.commit451.youtubeextractor.sample

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.commit451.youtubeextractor.YouTubeExtraction
import com.commit451.youtubeextractor.YouTubeExtractor
import com.devbrackets.android.exomedia.ui.widget.VideoView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    companion object {

        private const val GRID_YOUTUBE_ID = "9d8wWcJLnFI"

        private const val KEY_SAVED_POSITION = "saved_position"
    }

    private lateinit var imageView: ImageView
    private lateinit var description: TextView
    private lateinit var videoView: VideoView

    private var savedPosition: Int = 0

    private val extractor = YouTubeExtractor.Builder()
            .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.thumb)
        videoView = findViewById(R.id.video_view)
        description = findViewById(R.id.description)

        extractor.extract(GRID_YOUTUBE_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ extraction ->
                    bindVideoResult(extraction)
                }, { t ->
                    onError(t)
                })
        if (savedInstanceState != null) {
            savedPosition = savedInstanceState.getInt(KEY_SAVED_POSITION, 0)
        }
        videoView.setOnPreparedListener {
            videoView.volume = 0f
            videoView.seekTo(savedPosition.toLong())
            savedPosition = 0
            videoView.start()
        }
        videoView.setOnErrorListener { e ->
            e.printStackTrace()
            false
        }
    }

    override fun onResume() {
        super.onResume()
        videoView.seekTo(savedPosition.toLong())
        videoView.start()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_SAVED_POSITION, savedPosition)
    }

    private fun onError(t: Throwable) {
        t.printStackTrace()
        Toast.makeText(this@MainActivity, "It failed to extract. So sad", Toast.LENGTH_SHORT)
                .show()
    }

    private fun bindVideoResult(result: YouTubeExtraction) {
        val videoUrl = result.videoStreams.first().url
        Log.d("OnSuccess", "Got a result with the best url: $videoUrl")
        Glide.with(this)
                .load(result.thumbnails.first().url)
                .into(imageView)
        videoView.setVideoURI(Uri.parse(videoUrl))
    }
}
