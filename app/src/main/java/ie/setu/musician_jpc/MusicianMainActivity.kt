package ie.setu.musician_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import ie.setu.musician_jpc.ui.screens.home.HomeScreen
import ie.setu.musician_jpc.ui.theme.Musician_jpcTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MusicianMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // splashscreen: https://dev.to/elozino/getting-started-with-splash-screen-in-jetpack-compose-144l
        // https://gitlab.com/Elozino/kotlin-articles
        val splashscreen = installSplashScreen()
        var keepSplashScreen = true

        super.onCreate(savedInstanceState)
        splashscreen.setKeepOnScreenCondition { keepSplashScreen }
        lifecycleScope.launch {
            delay(2000)
            keepSplashScreen = false
        }
        enableEdgeToEdge()

        setContent {
            // dark theme source: https://www.youtube.com/watch?v=X8_w8Hqe0lA&t=186s
            var darkTheme by remember { mutableStateOf(true) }
            Musician_jpcTheme(darkTheme = darkTheme)
            {
                HomeScreen(darkTheme = darkTheme, onThemeChange = { darkTheme = !darkTheme })
            }
        }
    }
}