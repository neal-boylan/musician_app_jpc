package ie.setu.musician_jpc.ui.components.general

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun ToggleThemeButton(darkTheme: Boolean, onThemeChange: () -> Unit) {

    Switch(
        checked = darkTheme,
        onCheckedChange = {onThemeChange()},
        colors = SwitchDefaults.colors(
            checkedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            checkedThumbColor = MaterialTheme.colorScheme.primary,
            uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            uncheckedThumbColor = MaterialTheme.colorScheme.primary
        )
    )

}