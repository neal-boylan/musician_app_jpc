package ie.setu.musician_jpc.ui.components.addClip

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ie.setu.musician_jpc.R
import ie.setu.musician_jpc.ui.theme.Musician_jpcTheme

@Composable
fun TitleInput(
    modifier: Modifier = Modifier,
    onTitleChange: (String) -> Unit
) {

    var title by remember { mutableStateOf("") }

    OutlinedTextField(
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = MaterialTheme.colorScheme.primary,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
        ),
        maxLines = 2,
        value = title,
        onValueChange = {
            title = it
            onTitleChange(title)
        },
        modifier = modifier.fillMaxWidth(),
        label = { Text(stringResource(R.string.add_title)) }
    )
}

@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    Musician_jpcTheme {
        TitleInput(
            Modifier,
            onTitleChange = {})
    }
}