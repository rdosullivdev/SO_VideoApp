package com.silverorange.videoplayer.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.silverorange.videoplayer.databinding.ActivityMainBinding
import io.noties.markwon.Markwon

class MainActivity : AppCompatActivity(), Player.Listener {

    private val viewModel: VideoViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var exoPlayer: ExoPlayer
    private lateinit var markWon: Markwon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        exoPlayer = ExoPlayer.Builder(applicationContext).build().also {
            binding.playerView.player = it
            it.addListener(this@MainActivity)
        }
        markWon = Markwon.create(applicationContext)

        with(viewModel) {
            videoListState.observe(this@MainActivity) { videoList ->
                videoList.videos?.firstOrNull()?.let {
                    exoPlayer.clearMediaItems()
                    videoList.videos.forEach { video ->
                        video.streamMedia?.let { exoPlayer.addMediaItem(video.streamMedia) }
                    }
                    exoPlayer.prepare()
                }
            }
            currentVideoState.observe(this@MainActivity) { video ->
                binding.videoTitle.text = video.title
                binding.videoAuthor.text = video.author
                markWon.setMarkdown(binding.videoDesc, video.descMarkdown)
            }
        }
    }

    override fun onEvents(player: Player, events: Player.Events) {
        super.onEvents(player, events)
        player.currentMediaItem?.let {
            viewModel.videoPlaying(it.mediaId)
        }
    }

}