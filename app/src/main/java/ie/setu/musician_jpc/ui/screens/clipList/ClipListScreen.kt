package ie.setu.musician_jpc.ui.screens.clipList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ie.setu.musician_jpc.R
import ie.setu.musician_jpc.data.model.ClipModel
import ie.setu.musician_jpc.ui.components.clipList.ClipCardList
import ie.setu.musician_jpc.ui.components.clipList.ClipListText
import ie.setu.musician_jpc.ui.components.clipList.ShowAllToggle
import ie.setu.musician_jpc.ui.components.general.Centre
import ie.setu.musician_jpc.ui.components.general.ShowError
import ie.setu.musician_jpc.ui.components.general.ShowLoader
import ie.setu.musician_jpc.ui.components.general.ShowRefreshList
import timber.log.Timber

@Composable
fun ClipListScreen(modifier: Modifier = Modifier,
                   onClickClipDetails: (String) -> Unit,
                   clipListViewModel: ClipListViewModel = hiltViewModel())
{
    val clips = clipListViewModel.uiClips.collectAsState().value
    val isError = clipListViewModel.isErr.value
    val isLoading = clipListViewModel.isLoading.value
    val error = clipListViewModel.error.value
    // var showAll by remember { mutableStateOf(false) }
    var showAll = clipListViewModel.showAll.value
    var checked by remember { mutableStateOf(false) }
    val displayName = clipListViewModel.displayName

    Column {
        Column(
            modifier = modifier.padding(
                start = 24.dp,
                end = 24.dp
            ),
        ) {
            if(isLoading) ShowLoader("Loading Clips...")
            ClipListText(displayName = displayName)


            Switch(
                checked = checked,
                onCheckedChange = {
                    checked = it
                    clipListViewModel.showAll.value = it
                    if(checked) clipListViewModel.getAllClips() else clipListViewModel.getClips()
                }
            )
//            if(!isError)
//                ShowRefreshList(onClick = { reportViewModel.getDonations() })


            if (clips.isEmpty() && !isError)
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
            if (!isError) {
                ClipCardList(
                    clips = clips,
                    onClickClipDetails = onClickClipDetails,
                    onDeleteClip = { clip: ClipModel ->
                        clipListViewModel.deleteClip(clip)
                    },
//                    onRefreshList = { reportViewModel.getDonations() }
                )
            }
            if (isError) {
                ShowError(headline = error.message!! + " error...",
                    subtitle = error.toString(),
                    onClick = { clipListViewModel.getClips() })
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
            ClipListText(displayName = "Homer")
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
                    onClickClipDetails = {}
                )
        }
    }
}