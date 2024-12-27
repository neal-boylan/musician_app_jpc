package ie.setu.musician_jpc.ui.screens.details

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import ie.setu.musician_jpc.ui.components.details.DetailsScreenText
import ie.setu.musician_jpc.ui.components.details.ReadOnlyTextField
import ie.setu.musician_jpc.ui.components.details.YouTubePlayer
import ie.setu.musician_jpc.ui.components.general.ShowLoader
import android.net.Uri
import ie.setu.musician_jpc.ui.components.details.VideoPlayer
import ie.setu.musician_jpc.ui.components.general.ShowVideoPicker

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    detailViewModel: DetailsViewModel = hiltViewModel()
) {
    val clip = detailViewModel.clip.value
    val clipEmail = clip.email
    val errorEmptyDescription = "Description Cannot be Empty..."
    val errorShortDescription = "Description must be at least 2 characters"
    var titleText by rememberSaveable { mutableStateOf("") }
    var decscriptionText by rememberSaveable { mutableStateOf("") }
    var youTubeText by rememberSaveable { mutableStateOf("") }
    var onDescriptionChanged by rememberSaveable { mutableStateOf(false) }
    var isEmptyError by rememberSaveable { mutableStateOf(false) }
    var isShortError by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current
    val isError = detailViewModel.isErr.value
    val error = detailViewModel.error.value
    val isLoading = detailViewModel.isLoading.value
//    val videoUri = Uri.parse("android.resource://com.mkrdeveloper.videoplayercompose/raw/sample")
//    val videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"

    if(isLoading) ShowLoader("Retrieving Clip Details...")

    fun validate(text: String) {
        isEmptyError = text.isEmpty()
        isShortError = text.length < 2
        onDescriptionChanged = !(isEmptyError || isShortError)
    }

    if(isError)
        Toast.makeText(context,"Unable to fetch Details at this Time...",
            Toast.LENGTH_SHORT).show()
    if(!isError && !isLoading)
        Column(modifier = modifier.padding(
            start = 24.dp,
            end = 24.dp,
        ),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
            if (clipEmail == detailViewModel.emailAddress) {
                DetailsScreenText(edit = true, clip = clip)
            } else {
                DetailsScreenText(edit = false, clip = clip)
            }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize().padding(
                        start = 10.dp,
                        end = 10.dp,
                    ),
                )
                {
                    if (clip.mediaType == "YouTube") {
                        YouTubePlayer(
                            youtubeVideoId = clip.youTubeURL, //"kShAS6aafOU",
                            lifecycleOwner = LocalLifecycleOwner.current,
                            modifier = modifier.fillMaxSize()
                        )
                    } else {
                        VideoPlayer(
                            videoUri = Uri.parse(clip.videoURI),
                            modifier = modifier.fillMaxSize())
                        //VideoPlayerExo(videoUrl =videoUrl)
                    }

                    if (clipEmail == detailViewModel.emailAddress) {
                        Spacer(modifier = Modifier.height(8.dp))
                        youTubeText = clip.youTubeURL
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = youTubeText,
                            onValueChange = {
                                youTubeText = it
                                validate(youTubeText)
                                clip.mediaType = "YouTube"
                                clip.youTubeURL = youTubeText.substringAfterLast("=")
                                clip.videoURI = ""
                            },
                            maxLines = 1,
                            label = { Text(text = "Edit YouTube URL") },
                            isError = isEmptyError || isShortError,
                            supportingText = {
                                if (isEmptyError) {
                                    Text(
                                        modifier = Modifier.fillMaxWidth(),
                                        text = errorEmptyDescription,
                                        color = MaterialTheme.colorScheme.error
                                    )
                                } else
                                    if (isShortError) {
                                        Text(
                                            modifier = Modifier.fillMaxWidth(),
                                            text = errorShortDescription,
                                            color = MaterialTheme.colorScheme.error
                                        )
                                    }
                            },
                            trailingIcon = {
                                if (isEmptyError || isShortError)
                                    Icon(
                                        Icons.Filled.Warning,
                                        "error",
                                        tint = MaterialTheme.colorScheme.error
                                    )
                                else
                                    Icon(
                                        Icons.Default.Edit, contentDescription = "add/edit",
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                            },
                            keyboardActions = KeyboardActions { validate(youTubeText) },
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                            )
                        )

                        Text("OR")

                        ShowVideoPicker(
                            onVideoUriChanged = {
                                clip.videoURI = it.toString()
                                clip.youTubeURL = ""
                                clip.mediaType = "Video File"
                                validate(clip.videoURI)

                            }
                        )
                        titleText = clip.title
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = titleText,
                            onValueChange = {
                                titleText = it
                                validate(titleText)
                                clip.title = titleText
                            },
                            maxLines = 1,
                            label = { Text(text = "Edit Clip Title") },
                            isError = isEmptyError || isShortError,
                            supportingText = {
                                if (isEmptyError) {
                                    Text(
                                        modifier = Modifier.fillMaxWidth(),
                                        text = errorEmptyDescription,
                                        color = MaterialTheme.colorScheme.error
                                    )
                                } else
                                    if (isShortError) {
                                        Text(
                                            modifier = Modifier.fillMaxWidth(),
                                            text = errorShortDescription,
                                            color = MaterialTheme.colorScheme.error
                                        )
                                    }
                            },
                            trailingIcon = {
                                if (isEmptyError || isShortError)
                                    Icon(
                                        Icons.Filled.Warning,
                                        "error",
                                        tint = MaterialTheme.colorScheme.error
                                    )
                                else
                                    Icon(
                                        Icons.Default.Edit, contentDescription = "add/edit",
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                            },
                            keyboardActions = KeyboardActions { validate(titleText) },
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                            )
                        )

                        decscriptionText = clip.description
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = decscriptionText,
                            onValueChange = {
                                decscriptionText = it
                                validate(decscriptionText)
                                clip.description = decscriptionText
                            },
                            maxLines = 1,
                            label = { Text(text = "Edit Clip Description") },
                            isError = isEmptyError || isShortError,
                            supportingText = {
                                if (isEmptyError) {
                                    Text(
                                        modifier = Modifier.fillMaxWidth(),
                                        text = errorEmptyDescription,
                                        color = MaterialTheme.colorScheme.error
                                    )
                                } else
                                    if (isShortError) {
                                        Text(
                                            modifier = Modifier.fillMaxWidth(),
                                            text = errorShortDescription,
                                            color = MaterialTheme.colorScheme.error
                                        )
                                    }
                            },
                            trailingIcon = {
                                if (isEmptyError || isShortError)
                                    Icon(
                                        Icons.Filled.Warning,
                                        "error",
                                        tint = MaterialTheme.colorScheme.error
                                    )
                                else
                                    Icon(
                                        Icons.Default.Edit, contentDescription = "add/edit",
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                            },
                            keyboardActions = KeyboardActions { validate(decscriptionText) },
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                            )
                        )

                        Spacer(modifier.height(height = 4.dp))
                        Button(
                            onClick = {
                                detailViewModel.updateClip(clip)
                                onDescriptionChanged = false
                            },
                            elevation = ButtonDefaults.buttonElevation(20.dp),
                            enabled = onDescriptionChanged
                        ) {
                            Icon(Icons.Default.Save, contentDescription = "Save")
                            Spacer(modifier.width(width = 8.dp))
                            Text(
                                text = "Save",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                }
            }
}