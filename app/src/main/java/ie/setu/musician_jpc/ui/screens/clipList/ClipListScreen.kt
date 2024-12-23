package ie.setu.musician_jpc.ui.screens.clipList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ie.setu.musician_jpc.R
import ie.setu.musician_jpc.data.model.ClipModel
import ie.setu.musician_jpc.data.model.fakeClips
import ie.setu.musician_jpc.ui.components.clipList.ClipCardList
import ie.setu.musician_jpc.ui.components.clipList.ClipListText
import ie.setu.musician_jpc.ui.components.general.Centre
import ie.setu.musician_jpc.ui.components.general.ShowError
import ie.setu.musician_jpc.ui.components.general.ShowLoader
import ie.setu.musician_jpc.ui.screens.clip.PreviewClipScreen
import ie.setu.musician_jpc.ui.theme.Musician_jpcTheme
import timber.log.Timber

@Composable
fun ClipListScreen(modifier: Modifier = Modifier,
                   onClickClipDetails: (String) -> Unit,
                   clipListViewModel: ClipListViewModel = hiltViewModel(),
                   )
{
    val clips = clipListViewModel.uiClips.collectAsState().value
    val isError = clipListViewModel.isErr.value
    val isLoading = clipListViewModel.isLoading.value
    val error = clipListViewModel.error.value
    var checked by rememberSaveable  { mutableStateOf(false) }
    val displayName = clipListViewModel.displayName

    Timber.i("checked: $checked")
    Column {
        Column(
            modifier = modifier.padding(
                start = 24.dp,
                end = 24.dp
            ),
        ) {
            if(isLoading) ShowLoader("Loading Clips...")

            ClipListText()
            Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(24.dp)){
                Switch(
                    checked = checked,
                    onCheckedChange = {
                        checked = it
                        clipListViewModel.showAll.value = it
                        if (checked) clipListViewModel.getAllClips() else clipListViewModel.getClips()
                    }
                )
                clipListViewModel.showAll.value = checked
                if (checked) {
                    Text(
                        text = "Clips from all users",
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp,
                    )
                    // clipListViewModel.getAllClips()

                } else {
                    Text("Your clips",
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp,
                        )
                    // clipListViewModel.getClips()
                }

            }
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
                    email = clipListViewModel.emailAddress
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
fun PreviewClipListScreen(modifier: Modifier,
                          clips: SnapshotStateList<ClipModel>
) {

    var checked by remember { mutableStateOf(false) }

    Column {
        Column(
            modifier = modifier.padding(
                start = 24.dp,
                end = 24.dp
            ),
        ) {

            ClipListText()
            Row(horizontalArrangement = Arrangement.SpaceEvenly){
                Switch(
                    checked = checked,
                    onCheckedChange = {
                        checked = it
                    }
                )
                if (checked) {
                    Text("true", color = MaterialTheme.colorScheme.onPrimary)
                } else {
                    Text("false", color = MaterialTheme.colorScheme.onPrimary)
                }

            }
//            if(!isError)
//                ShowRefreshList(onClick = { reportViewModel.getDonations() })


            if (clips.isEmpty())
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

        }

    }
}

@Preview(showBackground = true)
@Composable
fun ClipListScreenPreview() {
    Musician_jpcTheme {
        PreviewClipListScreen( modifier = Modifier,
            clips = fakeClips.toMutableStateList())
    }
}