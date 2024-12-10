package ie.setu.musician_jpc.ui.components.addClip

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GenreChips(onGenreSelected: (MutableState<List<Genre?>>) -> Unit) {

    val selectedGenre: MutableState<List<Genre?>> = remember { mutableStateOf(listOf())}

    ChipGroup(
        genres = getAllGenres(),
        selectedGenres = selectedGenre.value,
        onSelectedChanged = {
            val oldList: MutableList<Genre?> = selectedGenre.value.toMutableList()
            val genreFromString = getGenre(it)

            if(oldList.contains(genreFromString)){
                oldList.remove(genreFromString)
            }else{
                oldList.add(genreFromString)
            }

            selectedGenre.value = oldList
            onGenreSelected(selectedGenre)
        }
    )

}

@Preview(showBackground = true)
@Composable
fun ChipGroup(
    genres: List<Genre> = getAllGenres(),
    selectedGenres: List<Genre?> = listOf(),
    onSelectedChanged: (String) -> Unit = {},
) {
    Column(modifier = Modifier.padding(8.dp)) {
        LazyRow {
            items(genres) {
                Chip(
                    name = it.value,
                    isSelected = selectedGenres.contains(it),
                    onSelectionChanged = {
                        onSelectedChanged(it)
                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Chip(
    name: String = "Chip",
    isSelected: Boolean = false,
    onSelectionChanged: (String) -> Unit = {},
) {
    Surface(
        modifier = Modifier.padding(4.dp),
        shape = MaterialTheme.shapes.medium,
        color = if (isSelected) Color.LightGray else Color.Black
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
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

enum class Genre(val value: String){
    Rock("Rock"),
    Pop("Pop"),
    Jazz("Jazz"),
}

fun getAllGenres(): List<Genre>{
    return listOf(Genre.Rock, Genre.Pop, Genre.Jazz)
}

fun getGenre(value: String): Genre? {
    val map = Genre.entries.associateBy(Genre::value)
    return map[value]
}