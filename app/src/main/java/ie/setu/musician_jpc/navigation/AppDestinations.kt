package ie.setu.musician_jpc.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

interface AppDestination {
    val icon: ImageVector
    val label: String
    val route: String
}

object ClipList : AppDestination {
    override val icon = Icons.AutoMirrored.Filled.List
    override val label = "View Clips"
    override val route = "clipList"
}

object ClipAdd : AppDestination {
    override val icon = Icons.Filled.AddCircle
    override val label = "Add Clip"
    override val route = "clipAdd"
}

object About : AppDestination {
    override val icon = Icons.Filled.Info
    override val label = "About"
    override val route = "about"
}

val bottomAppBarDestinations = listOf(About, ClipAdd, ClipList)
val allDestinations = listOf(ClipList, ClipAdd, About)