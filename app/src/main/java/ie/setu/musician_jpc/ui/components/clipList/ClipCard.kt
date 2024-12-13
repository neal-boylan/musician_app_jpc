package ie.setu.musician_jpc.ui.components.clipList

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AudioFile
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.VideoCameraFront
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ie.setu.musician_jpc.R
import ie.setu.musician_jpc.ui.components.addClip.ChipGroupString
import ie.setu.musician_jpc.ui.theme.Musician_jpcTheme
import ie.setu.musician_jpc.ui.theme.endGradientColor
import ie.setu.musician_jpc.ui.theme.startGradientColor
import java.text.DateFormat
import java.util.Date

@Composable
fun ClipCard(
    title: String,
    description: String,
    mediaType: String,
    instrument: String,
    genres: List<String>,
    dateAdded: String,
    dateModified: String,
    onClickDelete: () -> Unit,
    onClickClipDetails: () -> Unit
) {
    Card(
        border = BorderStroke(1.dp, Color.Black),
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
            dateAdded,
            dateModified,
            onClickDelete,
            onClickClipDetails)
    }
}

@Composable
private fun ClipCardContent(
    title: String,
    description: String,
    mediaType: String,
    instrument: String,
    genres: List<String>,
    dateAdded: String,
    dateModified: String,
    onClickDelete: () -> Unit,
    onClickClipDetails: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var showDeleteConfirmDialog by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            .background(brush = Brush.horizontalGradient(
                colors = listOf(
                    startGradientColor,
                    endGradientColor,
                )
            ))
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
                text = "Added on $dateAdded", style = MaterialTheme.typography.labelSmall
            )
            Text(
                text = "Modified on $dateModified", style = MaterialTheme.typography.labelSmall
            )

            ChipGroupString(genres = genres)

            if (expanded) {
                Text(modifier = Modifier.padding(vertical = 16.dp), text = description)
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    FilledTonalButton(onClick = onClickClipDetails ) {
                        Text(text = "Show More...")
                    }

                    FilledTonalIconButton(onClick = { showDeleteConfirmDialog = true }) {
                        Icon(Icons.Filled.Delete, "Delete ie.setu.donationx.firebase.services.Donation")
                    }
                    if (showDeleteConfirmDialog) {
                        showDeleteAlert(
                            onDismiss = { showDeleteConfirmDialog = false },
                            onDelete = onClickDelete
                        )
                    }
                }
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

@Composable
fun showDeleteAlert(
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
            dateAdded = DateFormat.getDateTimeInstance().format(Date()),
            dateModified = DateFormat.getDateTimeInstance().format(Date()),
            onClickDelete = { },
            onClickClipDetails = { }
        )
    }
}