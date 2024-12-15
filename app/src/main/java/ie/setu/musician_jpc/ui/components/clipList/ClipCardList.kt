package ie.setu.musician_jpc.ui.components.clipList

import android.net.Uri
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import ie.setu.musician_jpc.data.model.ClipModel
import ie.setu.musician_jpc.data.model.fakeClips
import ie.setu.musician_jpc.ui.theme.Musician_jpcTheme
import java.text.DateFormat

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