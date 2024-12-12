package ie.setu.musician_jpc.ui.screens.clipList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ie.setu.musician_jpc.data.ClipModel
import ie.setu.musician_jpc.data.repository.RoomRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClipListViewModel @Inject
constructor(private val repository: RoomRepository) : ViewModel() {
    private val _clips = MutableStateFlow<List<ClipModel>>(emptyList())
    val uiClips: StateFlow<List<ClipModel>> = _clips.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAll().collect { listOfClips ->
                _clips.value = listOfClips
            }
        }
    }
}