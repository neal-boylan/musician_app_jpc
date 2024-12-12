package ie.setu.musician_jpc.ui.screens.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ie.setu.musician_jpc.data.ClipModel
import ie.setu.musician_jpc.data.repository.RoomRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject
constructor(private val repository: RoomRepository,
            savedStateHandle: SavedStateHandle
            ) : ViewModel() {

    var clip = mutableStateOf(ClipModel())
    val id: Int = checkNotNull(savedStateHandle["id"])

    init {
        viewModelScope.launch {
            repository.get(id).collect { objDonation ->
                clip.value = objDonation
            }
        }
    }

    fun updateClip(clip: ClipModel) {
        viewModelScope.launch { repository.update(clip) }
    }
}