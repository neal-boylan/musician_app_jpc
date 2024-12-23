package ie.setu.musician_jpc.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Details
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument

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

object Search : AppDestination {
    override val icon = Icons.Filled.Search
    override val label = "Search"
    override val route = "search"
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

object Details : AppDestination {
    override val icon = Icons.Filled.Details
    override val label = "Details"
    const val idArg = "id"
    override val route = "details/{$idArg}"
    val arguments = listOf(
        navArgument(idArg) { type = NavType.StringType }
    )
}

object Home : AppDestination {
    override val icon = Icons.Filled.Home
    override val label = "Home"
    override val route = "Home"
}

object Profile : AppDestination {
    override val icon = Icons.Default.Person
    override val label = "Profile"
    override val route = "Profile"
}

object Login : AppDestination {
    override val icon = Icons.AutoMirrored.Filled.Login
    override val label = "Login"
    override val route = "Login"
}

object Register : AppDestination {
    override val icon = Icons.Default.AccountCircle
    override val label = "Register"
    override val route = "Register"
}

// val bottomAppBarDestinations = listOf(About, ClipList, Search, Profile, ClipAdd)
val bottomAppBarDestinations = listOf(ClipList, Search)
val userSignedOutDestinations = listOf(Login, Register)
val allDestinations = listOf(ClipList, ClipAdd, About, Details, Home, Profile, Login, Register, Search)