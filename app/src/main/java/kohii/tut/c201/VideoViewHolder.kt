package kohii.tut.c201

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.exoplayer2.ui.PlayerView

class VideoViewHolder(itemView: View) : ViewHolder(itemView) {

  val playerView: PlayerView = itemView.findViewById(R.id.playerView)
}
