package ie.setu.musician_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import ie.setu.musician_jpc.ui.screens.home.HomeScreen
import ie.setu.musician_jpc.ui.theme.Musician_jpcTheme

@AndroidEntryPoint
class MusicianMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Musician_jpcTheme { HomeScreen() }
        }
    }
}