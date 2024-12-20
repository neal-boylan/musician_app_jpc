package ie.setu.musician_jpc.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ie.setu.musician_jpc.ui.screens.about.AboutScreen
import ie.setu.musician_jpc.ui.screens.clip.ClipScreen
import ie.setu.musician_jpc.ui.screens.clipList.ClipListScreen
import ie.setu.musician_jpc.ui.screens.details.DetailsScreen
import ie.setu.musician_jpc.ui.screens.home.HomeScreen
import ie.setu.musician_jpc.ui.screens.login.LoginScreen
import ie.setu.musician_jpc.ui.screens.profile.ProfileScreen
import ie.setu.musician_jpc.ui.screens.register.RegisterScreen
import ie.setu.musician_jpc.ui.screens.search.SearchScreen
import ie.setu.musician_jpc.ui.screens.search.SearchViewModel

@Composable
fun NavHostProvider(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: AppDestination,
    paddingValues: PaddingValues,
    darkTheme: Boolean,
    onThemeChange: () -> Unit,
) {
    var search by remember { mutableStateOf(false) }

    NavHost(
        navController = navController,
        startDestination = startDestination.route,
        modifier = Modifier.padding(paddingValues = paddingValues)) {

        composable(route = ClipAdd.route) {
            //call our 'AddClip' Screen Here
            ClipScreen(modifier = modifier)
        }
        composable(route = Home.route) {
            //call our 'Home' Screen Here
            HomeScreen(modifier = modifier, darkTheme = darkTheme, onThemeChange = onThemeChange)
        }
        composable(route = ClipList.route) {
            //call our 'ClipList' Screen Here
            ClipListScreen(modifier = modifier,
                onClickClipDetails = {
                    clipId: String ->
                        navController.navigateToClipDetails(clipId)
                })
        }
        composable(route = Search.route) {
            //call our 'Search' Screen Here
            SearchScreen(modifier = modifier,
                onClickClipDetails = {
                        clipId: String ->
                    navController.navigateToClipDetails(clipId)
                })
        }
        composable(route = About.route) {
            //call our 'About' Screen Here
            AboutScreen(modifier = modifier)
        }
        composable(route = Login.route) {
            //call our 'Login' Screen Here
            LoginScreen(
                navController = navController,
                onLogin = { navController.popBackStack() }
            )
        }
        composable(route = Register.route) {
            //call our 'Register' Screen Here
            RegisterScreen(
                navController = navController,
                onRegister = { navController.popBackStack() }
            )
        }
        composable(
            route = Details.route,
            arguments = Details.arguments
        )
        { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getInt(Details.idArg)
            if (id != null) {
                DetailsScreen()
            }
        }
        composable(route = Profile.route) {
            ProfileScreen(
                onSignOut = {
                    navController.popBackStack()
                    navController.navigate(Login.route) {
                        popUpTo(Home.route) { inclusive = true }
                    }
                },
            )
        }
    }

}

private fun NavHostController.navigateToClipDetails(clipId: String) {
    this.navigate("details/$clipId")
}