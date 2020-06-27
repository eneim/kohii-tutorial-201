package kohii.tut.c201

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import kohii.v1.exoplayer.Kohii

class MainAdapter(
  private val kohii: Kohii,
  diffCallback: ItemCallback<VideoItem>
) : ListAdapter<VideoItem, VideoViewHolder>(diffCallback) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.holder_video_item, parent, false)
    return VideoViewHolder(view)
  }

  override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
    val videoItem = getItem(position) ?: return
    kohii.setUp(videoItem.videoUrl) {
      tag = "${videoItem.videoUrl}+${position}"
    }.bind(holder.playerView)
  }
}
