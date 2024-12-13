package ie.setu.musician_jpc.ui.screens.clipList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ie.setu.musician_jpc.data.model.ClipModel
import ie.setu.musician_jpc.data.api.RetrofitRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ClipListViewModel @Inject
constructor(private val repository: RetrofitRepository) : ViewModel() {
    private val _clips = MutableStateFlow<List<ClipModel>>(emptyList())
    val uiClips: StateFlow<List<ClipModel>> = _clips.asStateFlow()
    var isErr = mutableStateOf(false)
    var isLoading = mutableStateOf(false)
    var error = mutableStateOf(Exception())

//    init {
//        viewModelScope.launch {
//            repository.getAll().collect { listOfClips ->
//                _clips.value = listOfClips
//            }
//        }
//    }

    init { getClips() }

    fun getClips() {
        viewModelScope.launch {
            try {
                isLoading.value = true
                _clips.value = repository.getAll()
                isErr.value = false
                isLoading.value = false
            }
            catch(e:Exception) {
                isErr.value = true
                isLoading.value = false
                error.value = e
                Timber.i("RVM Error ${e.message}")
            }
        }
    }

    fun deleteClip(clip: ClipModel) {
        viewModelScope.launch {
            repository.delete(clip)
        }
    }
}