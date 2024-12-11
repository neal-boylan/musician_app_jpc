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

@Composable
fun NavHostProvider(
    modifier: Modifier,
    navController: NavHostController,
    paddingValues: PaddingValues,
    clips: SnapshotStateList<ClipModel>
) {
    NavHost(
        navController = navController,
        startDestination = ClipList.route,
        modifier = Modifier.padding(paddingValues = paddingValues)) {

        composable(route = ClipAdd.route) {
            //call our 'AddClip' Screen Here
            ClipScreen(modifier = modifier, clips = clips)
        }
        composable(route = ClipList.route) {
            //call our 'ClipList' Screen Here
            ClipListScreen(modifier = modifier, clips = clips)
        }
        composable(route = About.route) {
            //call our 'About' Screen Here
            AboutScreen(modifier = modifier)
        }
    }
}