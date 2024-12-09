package ie.setu.musician_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ie.setu.musician_jpc.data.ClipModel
import ie.setu.musician_jpc.ui.screens.ScreenClip
import ie.setu.musician_jpc.ui.theme.Musician_jpcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Musician_jpcTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MusicianApp(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun MusicianApp(modifier: Modifier = Modifier) {
    val clips = remember { mutableStateListOf<ClipModel>() }

    ScreenClip(modifier = modifier, clips = clips)
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    Musician_jpcTheme {
        MusicianApp(modifier = Modifier)
    }
}