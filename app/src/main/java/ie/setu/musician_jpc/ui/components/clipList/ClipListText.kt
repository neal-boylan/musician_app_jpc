package ie.setu.musician_jpc.ui.components.clipList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ie.setu.musician_jpc.ui.theme.Musician_jpcTheme
import ie.setu.musician_jpc.ui.theme.onPrimaryDark
import ie.setu.musician_jpc.ui.theme.onPrimaryLight

@Composable
fun ClipListText(modifier: Modifier = Modifier,
                 displayName: String) {
    Column(
        modifier = modifier.padding(
            top = 24.dp,
            bottom = 24.dp
        ),
        verticalArrangement = Arrangement.spacedBy(24.dp)) {
        Text(
            text = "Welcome $displayName",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = onPrimaryLight
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReportPreview() {
    Musician_jpcTheme {
        ClipListText(displayName = "Homer")
    }
}