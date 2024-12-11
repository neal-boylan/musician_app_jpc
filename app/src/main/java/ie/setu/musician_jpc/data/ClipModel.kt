package ie.setu.musician_jpc.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import kotlin.random.Random

@Entity
data class ClipModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String = "N/A",
    val description: String = "Just a little something",
    val mediaType: String = "N/A",
    val instrument: String = "N/A",
    val genres: List<String> = arrayListOf(),
    val dateAdded: Date = Date()
)

val fakeClips = List(30) { i ->
    ClipModel(
        id = 12345 + i,
        "My 1st clip",
        "A real crowd pleaser",
        "Audio $i",
        "Guitar $i",
        arrayListOf(),
        Date()
    )
}
