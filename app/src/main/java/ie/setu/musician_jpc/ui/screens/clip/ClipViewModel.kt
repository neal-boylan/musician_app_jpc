package ie.setu.musician_jpc.ui.screens.clip

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ie.setu.musician_jpc.data.ClipModel
import ie.setu.musician_jpc.data.repository.RoomRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClipViewModel @Inject
constructor(private val repository: RoomRepository) : ViewModel() {

    fun insert(clips: ClipModel)
            = viewModelScope.launch {
                repository.insert(clips)
            }
}