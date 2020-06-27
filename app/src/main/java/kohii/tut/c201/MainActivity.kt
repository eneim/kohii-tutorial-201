package kohii.tut.c201

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kohii.v1.exoplayer.Kohii

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val kohii = Kohii[this]

    val container: RecyclerView = findViewById(R.id.container)
    kohii.register(this)
      .addBucket(container)

    val adapter = MainAdapter(kohii, diffCallback = object : DiffUtil.ItemCallback<VideoItem>() {
      override fun areItemsTheSame(oldItem: VideoItem, newItem: VideoItem): Boolean =
        oldItem === newItem

      override fun areContentsTheSame(oldItem: VideoItem, newItem: VideoItem): Boolean =
        oldItem.position == newItem.position
    })
    container.adapter = adapter

    val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    viewModel.videos.observe(this, Observer { adapter.submitList(it) })
  }
}
