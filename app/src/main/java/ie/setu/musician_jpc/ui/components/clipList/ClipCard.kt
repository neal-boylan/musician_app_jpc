package ie.setu.musician_jpc.ui.components.clipList

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AudioFile
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.VideoCameraFront
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ie.setu.musician_jpc.R
import ie.setu.musician_jpc.ui.components.addClip.ChipGroupString
import ie.setu.musician_jpc.ui.theme.Musician_jpcTheme
import java.text.DateFormat
import java.util.Date

@Composable
fun ClipCard(
    title: String,
    description: String,
    mediaType: String,
    instrument: String,
    genres: List<String>,
    dateAdded: String
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 2.dp)
    ) {
        ClipCardContent(
            title,
            description,
            mediaType,
            instrument,
            genres,
            dateAdded)
    }
}

@Composable
private fun ClipCardContent(
    title: String,
    description: String,
    mediaType: String,
    instrument: String,
    genres: List<String>,
    dateAdded: String
) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (mediaType == "Audio") {
                    Icon(
                        imageVector = Icons.Filled.AudioFile,
                        "Clip Media Type",
                        Modifier.padding(end = 8.dp)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Filled.VideoCameraFront ,
                        "Clip Media Type",
                        Modifier.padding(end = 8.dp)
                    )
                }
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )

            }
            Text(
                text = instrument,
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )

            Text(
                text = "Clip added on $dateAdded", style = MaterialTheme.typography.labelSmall
            )

            ChipGroupString(genres = genres)
            if (expanded) {
                Text(modifier = Modifier.padding(vertical = 16.dp), text = description)
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }
            )
        }
    }
}

@Preview
@Composable
fun DonationCardPreview() {
    Musician_jpcTheme {
        ClipCard(
            title = "Sweet Child O Mine",
            description = "Chorus. I did my best!",
            mediaType = "Video",
            instrument = "Guitar",
            genres = listOf("Rock", "Pop"),
            dateAdded = DateFormat.getDateTimeInstance().format(Date())
        )
    }
}