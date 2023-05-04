package com.silverorange.videoplayer.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import com.silverorange.videoplayer.models.Video
import com.silverorange.videoplayer.models.VideoListState
import com.silverorange.videoplayer.network.VideoAPIService
import kotlinx.coroutines.launch

class VideoViewModel : ViewModel() {

    private val videoAPIService: VideoAPIService = VideoAPIService.create()

    val videoListState: MutableLiveData<VideoListState> by lazy {
        MutableLiveData<VideoListState>()
    }

    init {
        fetchVideos()
    }

    fun videoPlaying(id: String) {
        //todo - populate video details UI for currently playing video
    }

    private fun fetchVideos() {
        viewModelScope.launch {
            val videos = videoAPIService.fetchVideoList()
                ?.map {
                    Video(
                        id = it.id,
                        title = it.title,
                        author = it.author.name,
                        descMarkdown = it.description,
                        streamMedia = MediaItem.Builder()
                            .setMediaId(it.id)
                            .setUri(it.fullURL)
                            .build()
                    )
                }
            videoListState.value = VideoListState(videos)
        }
    }
}
