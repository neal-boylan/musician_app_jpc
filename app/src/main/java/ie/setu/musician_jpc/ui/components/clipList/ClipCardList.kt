package ie.setu.musician_jpc.ui.components.clipList

import android.net.Uri
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
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
) {

    LazyColumn {
        items(
            items = clips,
            key = { clip -> clip._id }
        ) { clip ->
            SwipeToDismissItem(
                item = clip,
                onRemove = { onDeleteClip(clip)},
                modifier = Modifier.animateItemPlacement(tween(200))
            )
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
}

@Composable
fun SwipeToDismissItem(
    item: ClipModel,
    onRemove: () -> Unit,
    modifier: Modifier = Modifier
){
    val coroutineScope = rememberCoroutineScope()
    val swipeToDismissState = rememberSwipeToDismissBoxState(
        confirmValueChange =  { state ->
        if(state == SwipeToDismissBoxValue.EndToStart){
            coroutineScope.launch {
                delay(1000)
                onRemove()
            }
            true
        } else {
            false
        }
        }
    )

    SwipeToDismissBox(
        state = swipeToDismissState,
        backgroundContent =  {
           val backgroundColor by  animateColorAsState(
               targetValue = when (swipeToDismissState.currentValue){
                    SwipeToDismissBoxValue.StartToEnd -> Color.Green
                    SwipeToDismissBoxValue.EndToStart -> Color.Red
                    SwipeToDismissBoxValue.Settled -> Color.White
               }, label = "Animate bg color"
           )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
            )
        },
        modifier = modifier
    ){
        Card {
            ListItem(
                headlineContent = { Text(text = item.title )}
            )
            HorizontalDivider()
        }
    }
}

@Preview(showBackground = true,
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE
)
@Composable
fun ClipCardListPreview() {
    Musician_jpcTheme {
        ClipCardList(
            fakeClips.toMutableStateList(),
            onDeleteClip = { },
            onClickClipDetails = { }
        )
    }
}