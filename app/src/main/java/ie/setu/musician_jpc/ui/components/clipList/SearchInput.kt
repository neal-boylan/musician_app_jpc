package ie.setu.musician_jpc.ui.components.clipList

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import ie.setu.musician_jpc.R

@Composable
fun SearchInput(
    search: String,
    modifier: Modifier = Modifier,
    onSearchTextChanged: (newSearchText: String) -> Unit
) {
    OutlinedTextField(
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = MaterialTheme.colorScheme.primary,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
        ),
        maxLines = 1,
        value = search,
        onValueChange = { newSearchText ->
            onSearchTextChanged(newSearchText)
        },
        modifier = modifier.fillMaxWidth(),
        label = { Text(stringResource(R.string.add_title)) },
        keyboardOptions = KeyboardOptions.Default.copy(
        imeAction = ImeAction.Done
        ),
    )
}