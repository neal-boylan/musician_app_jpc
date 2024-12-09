package ie.setu.musician_jpc.ui.components.addClip

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.chargemap.compose.numberpicker.ListItemPicker
import ie.setu.musician_jpc.ui.theme.Musician_jpcTheme

@Composable
fun InstrumentPicker(
    onInstrumentChange: (String) -> Unit
) {
    val possibleValues = listOf("Guitar", "Bass", "Drums", "Piano", "Vocals", "Keyboard")
    var pickerValue by remember { mutableStateOf(possibleValues[0]) }

    ListItemPicker(
        label = { it },
        dividersColor = MaterialTheme.colorScheme.primary,
        textStyle = TextStyle(Color.Black,20.sp),
        value = pickerValue,
        onValueChange = {
            pickerValue = it
            onInstrumentChange(pickerValue)
        },
        list = possibleValues
    )
}

@Preview(showBackground = true)
@Composable
fun PickerPreview() {
    Musician_jpcTheme {
        InstrumentPicker(onInstrumentChange = {})
    }
}