package ie.setu.musician_jpc.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ie.setu.musician_jpc.data.ClipModel
import ie.setu.musician_jpc.data.fakeClips
import ie.setu.musician_jpc.ui.components.addClip.AddClipButton
import ie.setu.musician_jpc.ui.components.addClip.ChipGroupString
import ie.setu.musician_jpc.ui.components.addClip.InstrumentPicker
import ie.setu.musician_jpc.ui.components.addClip.MessageInput
import ie.setu.musician_jpc.ui.components.addClip.ProgressBar
import ie.setu.musician_jpc.ui.components.addClip.RadioButtonGroup
import ie.setu.musician_jpc.ui.components.addClip.WelcomeText
import ie.setu.musician_jpc.ui.theme.Musician_jpcTheme

@Composable
fun ScreenClip(modifier: Modifier = Modifier,
               clips: SnapshotStateList<ClipModel>
) {

    var mediaType by remember { mutableStateOf("Video") }
    var instrument by remember { mutableStateOf("Guitar") }
    var clipMessage by remember { mutableStateOf("Go Homer!") }
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

            MessageInput(
                modifier = modifier.padding(top = 80.dp,bottom = 24.dp),
                onMessageChange = { clipMessage = it }
            )
            AddClipButton (
                modifier = modifier,
                clip = ClipModel(
                    mediaType = mediaType,
                    instrument = instrument,
                    genres = selectedGenre.value,
                    message = clipMessage),
                clips = clips,
                onTotalClipsChange = { totalClips = it }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClipScreenPreview() {
    Musician_jpcTheme {
        ScreenClip( modifier = Modifier,
            clips = fakeClips.toMutableStateList())
    }
}