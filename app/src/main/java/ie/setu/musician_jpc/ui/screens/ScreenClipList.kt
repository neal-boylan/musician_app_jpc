package ie.setu.musician_jpc.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ie.setu.musician_jpc.data.ClipModel
import ie.setu.musician_jpc.data.fakeClips
import ie.setu.musician_jpc.ui.components.clipList.ClipCardList
import ie.setu.musician_jpc.ui.components.clipList.ClipListText
import ie.setu.musician_jpc.ui.theme.Musician_jpcTheme

@Composable
fun ScreenClipList(modifier: Modifier = Modifier,
                   clips: SnapshotStateList<ClipModel>
) {

    Column {
        Column(
            modifier = modifier.padding(
                top = 48.dp,
                start = 24.dp,
                end = 24.dp
            ),
        ) {
            ClipListText()
            ClipCardList(
                clips = clips
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReportScreenPreview() {
    Musician_jpcTheme {
        ScreenClipList( modifier = Modifier,
            clips = fakeClips.toMutableStateList()
        )
    }
}