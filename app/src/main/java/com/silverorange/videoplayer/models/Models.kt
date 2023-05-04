package com.silverorange.videoplayer.models

data class VideoListState(
    val videos: List<Video>? = null
)

data class Video(
    val id: String = "",
    val title: String = "",
    val author: String = "",
    val streamMediaUrl: String = "",
    val descMarkdown: String = ""
)

