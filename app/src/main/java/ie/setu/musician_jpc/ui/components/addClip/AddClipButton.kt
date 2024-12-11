package ie.setu.musician_jpc.ui.components.addClip

import android.widget.Toast
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ie.setu.musician_jpc.R
import ie.setu.musician_jpc.data.ClipModel
import ie.setu.musician_jpc.data.fakeClips
import ie.setu.musician_jpc.ui.screens.ScreenClipList
import ie.setu.musician_jpc.ui.theme.Musician_jpcTheme
import timber.log.Timber

@Composable
fun AddClipButton(
    modifier: Modifier = Modifier,
    clip: ClipModel,
    clips: SnapshotStateList<ClipModel>,
    onTotalClipsChange: (Int) -> Unit
) {
    val context = LocalContext.current
    val totalClips = clips.size
    Row {
        Button(
            onClick = {
                clips.add(clip)
                onTotalClipsChange(totalClips)
                Toast.makeText(context, "Clip Added", Toast.LENGTH_LONG).show()
                Timber.i("Clip info : $clip")
                Timber.i("Donation List info : ${clips.toList()}")
            },
            elevation = ButtonDefaults.buttonElevation(20.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Donate")
            Spacer(modifier.width(width = 4.dp))
            Text(
                text = stringResource(R.string.addClipButton),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )
        }

        Spacer(modifier.weight(1f))
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                ) {
                    append(stringResource(R.string.totalClips))
                }

                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.secondary)
                ) {
                    append(totalClips.toString())
                }
            })
    }
}

@Preview(showBackground = true)
@Composable
fun DonateButtonPreview() {
    Musician_jpcTheme {
        AddClipButton(
            Modifier,
            ClipModel(),
            clips = fakeClips.toMutableStateList()
        ) {}
    }
}