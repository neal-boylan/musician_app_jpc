package ie.setu.musician_jpc.ui.components.general

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ie.setu.musician_jpc.navigation.AppDestination
import ie.setu.musician_jpc.navigation.ClipAdd
import ie.setu.musician_jpc.ui.theme.Musician_jpcTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarProvider(
    navController: NavController,
    currentScreen: AppDestination,
    canNavigateBack: Boolean,
    email: String,
    name: String,
    darkTheme: Boolean,
    onThemeChange: () -> Unit,
    navigateUp: () -> Unit = {})
{
    TopAppBar(
        title = {
            Column {
                Text(
                    text = currentScreen.label,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Row {
                    if (name.isNotEmpty())
                        Text(
                            text = name,
                            color = MaterialTheme.colorScheme.tertiaryContainer,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    if (email.isNotEmpty())
                        Text(
                            text = " ($email)",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color =  MaterialTheme.colorScheme.onPrimaryContainer
                        )
                }
            }
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back Button",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
            else
                IconButton(onClick = {
                }, content = {

                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = null,
                        tint = Color.White
                    )
                })

        },
        actions = {
            // ThemeSwitcher(darkTheme = darkTheme) { darkTheme = !darkTheme}
            ToggleThemeButton (darkTheme = darkTheme){ onThemeChange() }
            DropDownMenu(navController = navController)}

    )
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    Musician_jpcTheme {
        TopAppBarProvider(
            navController = rememberNavController(),
            ClipAdd,
            true,
            email = "dave@gmail.com",
            name = "userName!!",
            darkTheme = false,
            onThemeChange = {}
        )
    }
}