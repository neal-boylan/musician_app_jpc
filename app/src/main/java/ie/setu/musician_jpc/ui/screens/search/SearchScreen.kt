package ie.setu.musician_jpc.ui.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
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
import ie.setu.musician_jpc.ui.components.clipList.SearchInput
import ie.setu.musician_jpc.ui.components.general.Centre
import ie.setu.musician_jpc.ui.components.general.ShowError
import timber.log.Timber

@Composable
fun SearchScreen(modifier: Modifier = Modifier,
                 onClickClipDetails: (String) -> Unit,
                 searchViewModel: SearchViewModel = hiltViewModel(),
)
{
    val clips = searchViewModel.uiClips.collectAsState().value
    val isError = searchViewModel.isErr.value
    val isLoading = searchViewModel.isLoading.value
    val error = searchViewModel.error.value
    // var showAll by remember { mutableStateOf(false) }
    var showAll = searchViewModel.showAll.value
    var checked by remember { mutableStateOf(false) }
    val displayName = searchViewModel.displayName
    var search by remember { mutableStateOf("") }
//    var search by rememberSaveable(stateSaver = TextFieldValue.Saver) {
//        mutableStateOf(TextFieldValue("no search"))
//    }

    Column {
        Column(
            modifier = modifier.padding(
                start = 24.dp,
                end = 24.dp
            ),
        ) {
            // if(isLoading) ShowLoader("Loading Clips...")

            SearchInput(modifier = modifier.padding(top = 8.dp,bottom = 8.dp),
                search = search,
                onSearchTextChanged = { newSearchText ->
                    search = newSearchText
                },)
            Timber.i("search: $search")
            searchViewModel.getSearchList(search)

//            Switch(
//                checked = checked,
//                onCheckedChange = {
//                    checked = it
//                    searchViewModel.showAll.value = it
//                    if(checked) searchViewModel.getSearchList(search) else searchViewModel.getClips()
//                }
//            )
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
                    onDeleteClip = { clip: ClipModel ->
                        searchViewModel.deleteClip(clip)
                    },
                    onClickClipDetails = onClickClipDetails,
                    email = searchViewModel.emailAddress,
//                    onRefreshList = { reportViewModel.getDonations() }
                )
            }
            if (isError) {
                ShowError(headline = error.message!! + " error...",
                    subtitle = error.toString(),
                    onClick = { searchViewModel.getClips() })
            }
        }

    }
}

@Composable
fun PreviewSearchScreen(modifier: Modifier = Modifier,
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
                    onClickClipDetails = {},
                    email = ""
                )
        }
    }
}