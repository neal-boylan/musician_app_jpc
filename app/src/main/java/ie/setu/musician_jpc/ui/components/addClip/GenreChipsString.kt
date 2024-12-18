package ie.setu.musician_jpc.ui.components.addClip

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ie.setu.musician_jpc.ui.theme.onPrimaryLight
import ie.setu.musician_jpc.ui.theme.onSecondaryLight
import ie.setu.musician_jpc.ui.theme.onTertiaryLight
import ie.setu.musician_jpc.ui.theme.secondaryLight
import ie.setu.musician_jpc.ui.theme.tertiaryLight
import timber.log.Timber

@OptIn(ExperimentalLayoutApi::class)
@Preview(showBackground = true)
@Composable
fun ChipGroupString(
    modifier: Modifier = Modifier,
    genres: List<String> = listOf(),
    selectedGenres: List<String?> = listOf(),
    onSelectedChanged: (String) -> Unit = {},
) {

    // val possibleGenres= listOf("Rock", "Pop", "Jazz", "Blues", "Rap", "Metal", "Alternative", "Other")

    Column(modifier = Modifier.padding(8.dp)) {
        // https://stackoverflow.com/questions/68979046/how-to-do-multiline-chip-group-in-jetpack-compose
        // https://developer.android.com/develop/ui/compose/layouts/flow
        FlowRow (
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ){
            genres.forEach { it ->
                    ChipString(
                        name = it,
                        isSelected = selectedGenres.contains(it),
                        onSelectionChanged = {
                            onSelectedChanged(it)
                        },
                    )
            }
        }
    }
}

// @Preview(showBackground = true)
@Composable
fun ChipString(
    name: String = "Chip",
    isSelected: Boolean = false,
    onSelectionChanged: (String) -> Unit = {},
) {
    Surface(
        modifier = Modifier.padding(4.dp),
        shape = MaterialTheme.shapes.medium,
        color = if (isSelected) tertiaryLight else secondaryLight
    ) {
        Row(modifier = Modifier
            .toggleable(
                value = isSelected,
                onValueChange = {
                    onSelectionChanged(name)
                }
            )
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium,
                color = if (isSelected) onTertiaryLight else onSecondaryLight,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
