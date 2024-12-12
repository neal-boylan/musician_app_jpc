package ie.setu.musician_jpc.ui.screens.clipList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ie.setu.musician_jpc.R
import ie.setu.musician_jpc.data.ClipModel
import ie.setu.musician_jpc.ui.components.clipList.ClipCardList
import ie.setu.musician_jpc.ui.components.clipList.ClipListText
import ie.setu.musician_jpc.ui.components.general.Centre

@Composable
fun ClipListScreen(modifier: Modifier = Modifier,
                   onClickClipDetails: (Int) -> Unit,
                   clipListViewModel: ClipListViewModel = hiltViewModel())
{
    val clips = clipListViewModel.uiClips.collectAsState().value

    Column {
        Column(
            modifier = modifier.padding(
                // top = 48.dp,
                start = 24.dp,
                end = 24.dp
            ),
        ) {
            ClipListText()

            if (clips.isEmpty()) {
                Centre(Modifier.fillMaxSize()) {
                    Text(
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        lineHeight = 34.sp,
                        textAlign = TextAlign.Center,
                        text = stringResource(R.string.empty_list)
                    )
                }
            } else {
                ClipCardList(
                    clips = clips,
                    onClickClipDetails = onClickClipDetails,
                    onDeleteClip = {
                            clip: ClipModel -> clipListViewModel.deleteClip(clip)
                    }
                )
            }
        }
    }
}

@Composable
fun PreviewClipListScreen(modifier: Modifier = Modifier,
                        clips: SnapshotStateList<ClipModel>
) {
    Column {
        Column(
            modifier = modifier.padding(
                start = 24.dp,
                end = 24.dp
            ),
        ) {
            ClipListText()
            if(clips.isEmpty())
                Centre(Modifier.fillMaxSize()) {
                    Text(color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        lineHeight = 34.sp,
                        textAlign = TextAlign.Center,
                        text = stringResource(R.string.empty_list)
                    )
                }
            else
                ClipCardList(
                    clips = clips,
                    onDeleteClip = {},
                    onClickClipDetails = { }
                )
        }
    }
}