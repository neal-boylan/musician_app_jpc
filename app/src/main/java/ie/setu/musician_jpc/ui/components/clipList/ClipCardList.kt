package ie.setu.musician_jpc.ui.components.clipList

import android.net.Uri
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxState
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import ie.setu.musician_jpc.R
import ie.setu.musician_jpc.data.model.ClipModel
import ie.setu.musician_jpc.data.model.fakeClips
import ie.setu.musician_jpc.ui.theme.Musician_jpcTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.DateFormat

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun ClipCardList(
    clips: List<ClipModel>,
    modifier: Modifier = Modifier,
    onDeleteClip: (ClipModel) -> Unit,
    onClickClipDetails: (String) -> Unit,
    email: String,
) {

    LazyColumn {
        items(
            items = clips,
            key = { clip -> clip._id }
        ) { clip ->
            if (clip.email == email) {
                //Allow swiping to delete clips if email matches logged in user
                SwipeToDismissItem(
                    clip = clip,
                    onRemove = { onDeleteClip(clip) },
                    modifier = Modifier.animateItemPlacement(tween(200)),
                    onDeleteClip = onDeleteClip,
                    onClickClipDetails = onClickClipDetails
                )
            } else {
                // User cannot delete cards that aren't theirs
//                SwipeToDismissItem(
//                    clip = clip,
//                    onRemove = {  },
//                    modifier = Modifier.animateItemPlacement(tween(200)),
//                    onDeleteClip = {  },
//                    onClickClipDetails = onClickClipDetails
//                )
                ClipCard(
                    title = clip.title,
                    description = clip.description,
                    mediaType = clip.mediaType,
                    instrument = clip.instrument,
                    genres = clip.genres,
                    dateAdded = DateFormat.getDateTimeInstance().format(clip.dateAdded),
                    dateModified = DateFormat.getDateTimeInstance().format(clip.dateModified),
                    onClickDelete = {  },
                    onClickClipDetails = { onClickClipDetails(clip._id) },
                    photoUri = Uri.parse(clip.imageUri)
                )
           }
        }
    }
}

@Composable
fun SwipeToDismissItem(
    // source: https://www.youtube.com/watch?v=Y0xGMXW_b1o
    clip: ClipModel,
    onRemove: () -> Unit,
    onDeleteClip: (ClipModel) -> Unit,
    onClickClipDetails: (String) -> Unit,
    modifier: Modifier = Modifier
){
    var showDeleteConfirmDialog by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val swipeToDismissState = rememberSwipeToDismissBoxState(
        confirmValueChange =  { state ->
        if(state == SwipeToDismissBoxValue.StartToEnd){
            coroutineScope.launch {
                delay(1000)
                showDeleteConfirmDialog = true
                // onRemove()
            }
            false
        } else if(state == SwipeToDismissBoxValue.EndToStart){
            coroutineScope.launch {
                delay(1000)
                onClickClipDetails(clip._id)
            }
            false
        } else {
            false
        }
        }
    )

    if (showDeleteConfirmDialog) {
        showDeleteAlert(
            onDismiss = { showDeleteConfirmDialog = false },
            onDelete = onRemove
        )
    }

    SwipeToDismissBox(
        state = swipeToDismissState,
        backgroundContent =  {
            DismissBackground(swipeToDismissState)
//           val backgroundColor by  animateColorAsState(
//               targetValue = when (swipeToDismissState.currentValue){
//                    SwipeToDismissBoxValue.StartToEnd -> Color.Green
//                    SwipeToDismissBoxValue.EndToStart -> Color.Red
//                    SwipeToDismissBoxValue.Settled -> Color.Transparent
//               },
//               label = "Animate bg color",
//           )
//            Box(modifier = Modifier
//                .fillMaxSize()
//                .background(backgroundColor)
//            )
        },
        modifier = modifier,
    ){
        ClipCard(
            title = clip.title,
            description = clip.description,
            mediaType = clip.mediaType,
            instrument = clip.instrument,
            genres = clip.genres,
            dateAdded = DateFormat.getDateTimeInstance().format(clip.dateAdded),
            dateModified = DateFormat.getDateTimeInstance().format(clip.dateModified),
            onClickDelete = { onDeleteClip(clip) },
            onClickClipDetails = { onClickClipDetails(clip._id) },
            photoUri = Uri.parse(clip.imageUri)
        )
    }
}

@Composable
fun DismissBackground(dismissState: SwipeToDismissBoxState) {
    val color = when (dismissState.dismissDirection) {
        SwipeToDismissBoxValue.StartToEnd -> Color(0xFFFF1744)
        SwipeToDismissBoxValue.EndToStart -> Color(0xFF1DE9B6)
        SwipeToDismissBoxValue.Settled -> Color.Transparent
    }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(12.dp, 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            Icons.Default.Delete,
            contentDescription = "delete"
        )
        Spacer(modifier = Modifier)
        Icon(
            // make sure add baseline_archive_24 resource to drawable folder
            Icons.Default.Edit,
            contentDescription = "open"
        )
    }
}

@Composable
fun ShowDeleteAlert(
    onDismiss: () -> Unit,
    onDelete: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss ,
        title = { Text(stringResource(id = R.string.confirm_delete)) },
        text = { Text(stringResource(id = R.string.confirm_delete_message)) },
        confirmButton = {
            Button(
                onClick = {
                    onDelete()
                }
            ) { Text("Yes") }
        },
        dismissButton = {
            Button(onClick = onDismiss) { Text("No") }
        }
    )
}


@Composable
fun ClipCardListPreview() {
    Musician_jpcTheme {
        ClipCardList(
            fakeClips.toMutableStateList(),
            onDeleteClip = { },
            onClickClipDetails = { },
            email = ""
        )
    }
}