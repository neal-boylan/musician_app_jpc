package ie.setu.musician_jpc.data

import java.util.Date
import kotlin.random.Random

data class ClipModel(
    val id: Int = Random.nextInt(1, 100000),
    val mediaType: String = "N/A",
    val instrument: String = "N/A",
    val genres: List<String?> = arrayListOf(),
    val message: String = "Just a little something",
    val dateAdded: Date = Date()
)

val fakeClips = List(30) { i ->
    ClipModel(
        id = 12345 + i,
        "PayPal $i",
        "Guitar $i",
        arrayListOf(),
        "Message $i",
        Date()
    )
}
