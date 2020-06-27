package kohii.tut.c201

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

  private val _videos = MutableLiveData(
    Array(100) { VideoItem(position = it) }.toList()
  )

  val videos: LiveData<List<VideoItem>> = _videos
}
