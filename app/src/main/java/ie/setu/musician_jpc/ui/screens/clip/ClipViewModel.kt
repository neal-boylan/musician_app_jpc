package ie.setu.musician_jpc.ui.screens.clip

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ie.setu.musician_jpc.data.model.ClipModel
import ie.setu.musician_jpc.firebase.services.AuthService
import ie.setu.musician_jpc.firebase.services.FirestoreService
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ClipViewModel @Inject
constructor(private val repository: FirestoreService,
            private val authService: AuthService,
            private val firestoreService: FirestoreService
) : ViewModel() {

    var isErr = mutableStateOf(false)
    var error = mutableStateOf(Exception())
    var isLoading = mutableStateOf(false)

    fun insert(clip: ClipModel) =
        viewModelScope.launch {
            try {
                isLoading.value = true
                repository.insert(authService.email!!, clip)
                isErr.value = false
                isLoading.value = false
            } catch (e: Exception) {
                isErr.value = true
                error.value = e
                isLoading.value = false
            }
            Timber.i("DVM Insert Message = : ${error.value.message} and isError ${isErr.value}")
        }

}