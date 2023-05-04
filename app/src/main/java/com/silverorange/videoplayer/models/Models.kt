package com.silverorange.videoplayer.models

import androidx.media3.common.MediaItem

data class VideoListState(
    val videos: List<Video>? = null
)

data class Video(
    val id: String = "",
    val title: String = "",
    val author: String = "",
    val streamMedia: MediaItem? = null,
    val descMarkdown: String = ""
)

