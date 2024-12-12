package ie.setu.musician_jpc.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ie.setu.musician_jpc.data.ClipModel
import ie.setu.musician_jpc.ui.screens.about.AboutScreen
import ie.setu.musician_jpc.ui.screens.clip.ClipScreen
import ie.setu.musician_jpc.ui.screens.clipList.ClipListScreen
import ie.setu.musician_jpc.ui.screens.details.DetailsScreen

@Composable
fun NavHostProvider(
    modifier: Modifier,
    navController: NavHostController,
    paddingValues: PaddingValues,
) {
    NavHost(
        navController = navController,
        startDestination = ClipList.route,
        modifier = Modifier.padding(paddingValues = paddingValues)) {

        composable(route = ClipAdd.route) {
            //call our 'AddClip' Screen Here
            ClipScreen(modifier = modifier)
        }
        composable(route = ClipList.route) {
            //call our 'ClipList' Screen Here
            ClipListScreen(modifier = modifier,
                onClickClipDetails = {
                    clipId: Int ->
                        navController.navigateToClipDetails(clipId)
                },)
        }
        composable(route = About.route) {
            //call our 'About' Screen Here
            AboutScreen(modifier = modifier)
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
    }
}

private fun NavHostController.navigateToClipDetails(clipId: Int) {
    this.navigate("details/$clipId")
}