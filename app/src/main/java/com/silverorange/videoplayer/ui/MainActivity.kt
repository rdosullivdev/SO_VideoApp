package com.silverorange.videoplayer.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.silverorange.videoplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: VideoViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var exoPlayer: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        exoPlayer = ExoPlayer.Builder(applicationContext).build().also {
            binding.playerView.player = it
        }

        with(viewModel) {
            videoListState.observe(this@MainActivity) { videoList ->
                videoList.videos?.firstOrNull()?.let {
                    exoPlayer.setMediaItem(MediaItem.fromUri(it.streamMediaUrl))
                    exoPlayer.prepare()
                    exoPlayer.play()
                }
            }
        }
    }

}