package ie.setu.musician_jpc.ui.screens.clip

import android.net.Uri
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ie.setu.musician_jpc.data.model.ClipModel
import ie.setu.musician_jpc.data.model.fakeClips
import ie.setu.musician_jpc.ui.components.addClip.AddClipButton
import ie.setu.musician_jpc.ui.components.addClip.ChipGroupString
import ie.setu.musician_jpc.ui.components.addClip.InstrumentPicker
import ie.setu.musician_jpc.ui.components.addClip.DescriptionInput
import ie.setu.musician_jpc.ui.components.addClip.RadioButtonGroup
import ie.setu.musician_jpc.ui.components.addClip.TitleInput
import ie.setu.musician_jpc.ui.components.addClip.WelcomeText
import ie.setu.musician_jpc.ui.components.addClip.YouTubeURLInput
import ie.setu.musician_jpc.ui.components.general.ShowPhotoPicker
import ie.setu.musician_jpc.ui.components.general.ShowVideoPicker
import ie.setu.musician_jpc.ui.screens.clipList.ClipListViewModel
import ie.setu.musician_jpc.ui.theme.Musician_jpcTheme

@Composable
fun ClipScreen(modifier: Modifier = Modifier,
               clipListViewModel: ClipListViewModel = hiltViewModel(),
               clipViewModel: ClipViewModel = hiltViewModel()
) {
    var clipTitle by remember { mutableStateOf("Sweet Child O Mine") }
    var clipDescription by remember { mutableStateOf("Go Homer!") }
    var youTubeURL by remember { mutableStateOf("https://www.youtube.com/watch?v=zXyCAuVVKuM")  }
    var mediaType by remember { mutableStateOf("YouTube") }
    var instrument by remember { mutableStateOf("Guitar") }
    var totalClips by remember { mutableIntStateOf(0) }
    val selectedGenre: MutableState<List<String>> = remember {mutableStateOf(listOf())}
    val possibleGenres = listOf("Rock", "Pop", "Jazz", "Blues", "Rap", "Metal", "Alternative", "Other")
    val clips = clipListViewModel.uiClips.collectAsState().value
    var videoUri: Uri? by remember { mutableStateOf(Uri.EMPTY) }

    Column {
        Column(
            modifier = modifier.padding(
                // top = 48.dp,
                start = 24.dp,
                end = 24.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {

            WelcomeText()

            TitleInput(
                modifier = modifier.padding(top = 8.dp,bottom = 8.dp),
                onTitleChange = { clipTitle = it }
            )

            DescriptionInput(
                modifier = modifier.padding(top = 8.dp,bottom = 8.dp),
                onDescriptionChange = { clipDescription = it }
            )
            if(mediaType == "YouTube") {
                YouTubeURLInput(
                    modifier = modifier.padding(top = 8.dp, bottom = 8.dp),
                    onDescriptionChange = { youTubeURL = it }
                )
            } else {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                )
                {
                    ShowVideoPicker(
                        onVideoUriChanged = {
                            videoUri = it
                            // clipViewModel.updateVideoUri(videoUri!!)
                        }
                    )
                    Spacer(modifier.weight(1f))
                    Text(videoUri.toString())
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
            )
            {
                RadioButtonGroup(
                    modifier = modifier,
                    onPaymentTypeChange = { mediaType = it }
                )
                Spacer(modifier.weight(1f))
                InstrumentPicker (
                    onInstrumentChange = { instrument = it }
                )
            }

            ChipGroupString(
                modifier = modifier.padding(top = 8.dp,bottom = 8.dp),
                genres = possibleGenres,
                selectedGenres = selectedGenre.value,
                onSelectedChanged = {
                    val oldList: MutableList<String> = selectedGenre.value.toMutableList()
                    val genreFromString = it

                    if(oldList.contains(genreFromString)){
                        oldList.remove(genreFromString)
                    }else{
                        oldList.add(genreFromString)
                    }

                    selectedGenre.value = oldList
                })

            /*ProgressBar(
                modifier = modifier.padding(top = 80.dp,bottom = 24.dp),
                totalClips = totalClips)*/

            AddClipButton (
                modifier = modifier,
                clip = ClipModel(
                    title = clipTitle,
                    description = clipDescription,
                    mediaType = mediaType,
                    instrument = instrument,
                    genres = selectedGenre.value,
                    youTubeURL = youTubeURL.substringAfterLast("="),
                    videoURI = videoUri.toString()
                    ),
                onTotalClipsChange = { totalClips = it }
            )
        }
    }
}

@Composable
fun PreviewClipScreen(modifier: Modifier = Modifier,
                        clips: SnapshotStateList<ClipModel>
) {
    var clipTitle by remember { mutableStateOf("Sweet Child O Mine") }
    var clipDescription by remember { mutableStateOf("Go Homer!") }
    var mediaType by remember { mutableStateOf("Video") }
    var instrument by remember { mutableStateOf("Guitar") }
    var totalClips by remember { mutableIntStateOf(0) }
    val selectedGenre: MutableState<List<String>> = remember {mutableStateOf(listOf())}
    val possibleGenres = listOf("Rock", "Pop", "Jazz", "Blues", "Rap", "Metal", "Alternative", "Other")

    Column {
        Column(
            modifier = modifier.padding(
                // top = 48.dp,
                start = 24.dp,
                end = 24.dp
            ),
            verticalArrangement = Arrangement.spacedBy(30.dp),
        ) {

            WelcomeText()

            TitleInput(
                modifier = modifier.padding(top = 8.dp,bottom = 8.dp),
                onTitleChange = { clipTitle = it }
            )

            DescriptionInput(
                modifier = modifier.padding(top = 8.dp,bottom = 8.dp),
                onDescriptionChange = { clipDescription = it }
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            )
            {
                RadioButtonGroup(
                    modifier = modifier,
                    onPaymentTypeChange = { mediaType = it }
                )
                Spacer(modifier.weight(1f))
                InstrumentPicker (
                    onInstrumentChange = { instrument = it }
                )
            }

            ChipGroupString(
                modifier = modifier.padding(top = 8.dp,bottom = 8.dp),
                genres = possibleGenres,
                selectedGenres = selectedGenre.value,
                onSelectedChanged = {
                    val oldList: MutableList<String> = selectedGenre.value.toMutableList()
                    val genreFromString = it

                    if(oldList.contains(genreFromString)){
                        oldList.remove(genreFromString)
                    }else{
                        oldList.add(genreFromString)
                    }

                    selectedGenre.value = oldList
                })

            /*ProgressBar(
                modifier = modifier.padding(top = 80.dp,bottom = 24.dp),
                totalClips = totalClips)*/

            AddClipButton (
                modifier = modifier,
                clip = ClipModel(
                    title = clipTitle,
                    description = clipDescription,
                    mediaType = mediaType,
                    instrument = instrument,
                    genres = selectedGenre.value,
                ),
                onTotalClipsChange = { totalClips = it }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClipScreenPreview() {
    Musician_jpcTheme {
        PreviewClipScreen( modifier = Modifier,
            clips = fakeClips.toMutableStateList())
    }
}