package com.silverorange.videoplayer.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    private fun fetchVideos() {
        viewModelScope.launch {
            val videos = videoAPIService.fetchVideoList()
                ?.map {
                    Video(
                        id = it.id,
                        title = it.title,
                        author = it.author.name,
                        descMarkdown = it.description,
                        streamMediaUrl = it.fullURL
                    )
                }
            videoListState.value = VideoListState(videos)
        }
    }
}
