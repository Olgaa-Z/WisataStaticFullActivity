package com.belajar.wisata

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class VideoWisata : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {

    lateinit var yb: YouTubePlayerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_wisata)

        yb=findViewById(R.id.YoutubePlayer)
        yb.initialize("IzaSyAYmbOhDRWXLw3Oj4XxtC13RSZkMZ9QIw4",this)
        requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {
        p1!!.setFullscreen(true)
        p1.cueVideo("pX8FEUwEt1o")
        p1.play()

    }

    override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
        if (p1!!.isUserRecoverableError){
            p1.getErrorDialog(this,1).show()
        }
    }
}
