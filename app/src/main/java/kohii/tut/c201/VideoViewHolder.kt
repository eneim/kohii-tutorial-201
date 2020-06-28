package kohii.tut.c201

import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class VideoViewHolder(itemView: View) : ViewHolder(itemView) {

  val playerView: FrameLayout = itemView.findViewById(R.id.playerViewContainer)
}
