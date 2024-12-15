package ie.setu.musician_jpc.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.firestore.DocumentId
import java.util.Date

// @Entity
data class ClipModel(
    @DocumentId val _id: String = "N/A",
    var title: String = "N/A",
    var description: String = "Just a little something",
    val mediaType: String = "N/A",
    val instrument: String = "N/A",
    val genres: List<String> = arrayListOf(),
    val dateAdded: Date = Date(),
    val dateModified: Date = Date(),
    var email: String = "joe@bloggs.com",
    var imageUri: String = ""
)

val fakeClips = List(30) { i ->
    ClipModel(
        _id = "12345" + i,
        "My 1st clip",
        "A real crowd pleaser",
        "Audio $i",
        "Guitar $i",
        arrayListOf(),
        Date(),
        Date()
    )
}
