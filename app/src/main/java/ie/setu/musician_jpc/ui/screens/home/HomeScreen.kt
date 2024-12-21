package ie.setu.musician_jpc.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ie.setu.musician_jpc.navigation.Login
import ie.setu.musician_jpc.navigation.NavHostProvider
import ie.setu.musician_jpc.navigation.ClipList
import ie.setu.musician_jpc.navigation.allDestinations
import ie.setu.musician_jpc.navigation.bottomAppBarDestinations
import ie.setu.musician_jpc.navigation.userSignedOutDestinations
import ie.setu.musician_jpc.ui.components.general.BottomAppBarProvider
import ie.setu.musician_jpc.ui.components.general.TopAppBarProvider
import ie.setu.musician_jpc.ui.theme.Musician_jpcTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(modifier: Modifier = Modifier,
               homeViewModel: HomeViewModel = hiltViewModel(),
               navController: NavHostController = rememberNavController(),
               darkTheme: Boolean,
               onThemeChange: () -> Unit
) {
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentNavBackStackEntry?.destination
    val currentBottomScreen =
        allDestinations.find { it.route == currentDestination?.route } ?: Login
    var startScreen = currentBottomScreen

    val currentUser = homeViewModel.currentUser
    val isActiveSession = homeViewModel.isAuthenticated()
    val userEmail = if (isActiveSession) currentUser?.email else ""
    val userName = if (isActiveSession) currentUser?.displayName else ""
    val userDestinations = if (!isActiveSession)
        userSignedOutDestinations
    else bottomAppBarDestinations

    if (isActiveSession) startScreen = ClipList

    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(onClick = {},
                shape = CircleShape,
                modifier = Modifier
                    //.align(Alignment.Center)
                    .size(80.dp)
                    .offset(y = 50.dp)
                ) {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = "add")
            }
        },
        topBar = { TopAppBarProvider(
            navController = navController,
            currentScreen = currentBottomScreen,
            canNavigateBack = navController.previousBackStackEntry != null,
            email = userEmail!!,
            name = userName!!,
            darkTheme = darkTheme,
            onThemeChange = onThemeChange
        ) { navController.navigateUp() }
        },
        content = { paddingValues ->
            NavHostProvider(
                modifier = modifier,
                navController = navController,
                startDestination = startScreen,
                paddingValues = paddingValues,
                darkTheme = darkTheme,
                onThemeChange = onThemeChange
            )
        },
        bottomBar = {
            BottomAppBarProvider(
                navController,
                currentScreen = currentBottomScreen,
                userDestinations,
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
    )
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    Musician_jpcTheme() {
        HomeScreen(modifier = Modifier, darkTheme = false, onThemeChange = { })
    }
}