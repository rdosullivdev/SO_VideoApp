package com.silverorange.videoplayer.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import com.silverorange.videoplayer.models.Video
import com.silverorange.videoplayer.models.VideoListState
import com.silverorange.videoplayer.network.VideoAPIService
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat

class VideoViewModel : ViewModel() {

    //Would inject via with di in larger project.
    private val videoAPIService: VideoAPIService = VideoAPIService.create()

    val videoListState: MutableLiveData<VideoListState> by lazy {
        MutableLiveData<VideoListState>()
    }
    val currentVideoState: MutableLiveData<Video> by lazy {
        MutableLiveData<Video>()
    }
    private var videos: List<Video>? = null

    init {
        fetchVideos()
    }

    fun videoPlaying(id: String) {
        videos?.find { it.id == id }?.let { currentVideo ->
            currentVideoState.value = currentVideo
        }
    }

    private fun fetchVideos() {
        viewModelScope.launch {
            videos = videoAPIService.fetchVideoList()
                ?.sortedBy {
                    SimpleDateFormat(TIMESTAMP_FORMAT).parse(it.publishedAt)?.time
                }
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

    companion object {
        const val TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS"
    }
}
