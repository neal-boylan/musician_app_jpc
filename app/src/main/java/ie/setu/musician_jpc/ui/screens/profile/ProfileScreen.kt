package ie.setu.musician_jpc.ui.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ie.setu.musician_jpc.R
import ie.setu.musician_jpc.ui.components.general.HeadingTextComponent
import ie.setu.musician_jpc.ui.screens.login.LoginViewModel
import ie.setu.musician_jpc.ui.screens.register.RegisterViewModel

@Composable
fun ProfileScreen(
    onSignOut: () -> Unit = {},
    profileViewModel: ProfileViewModel = hiltViewModel(),
    loginViewModel: LoginViewModel = hiltViewModel(),
    registerViewModel: RegisterViewModel = hiltViewModel()
) {

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        HeadingTextComponent(value = stringResource(id = R.string.account_settings))
        Spacer(modifier = Modifier.height(10.dp))
        //   if(loginViewModel.currentUser?.photoUrl?.path.isNullOrEmpty())
        BasicContent(
            displayName = profileViewModel.displayName,
            emailAddress = profileViewModel.emailAddress
        )
//        else
//            ProfileContent(
//                photoUrl = profileViewModel.photoUrl,
//                displayName = profileViewModel.displayName
//        )

        Button(
            onClick = {
                profileViewModel.signOut()
                onSignOut()
                loginViewModel.resetLoginFlow()
                registerViewModel.resetRegisterFlow()
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = MaterialTheme.colorScheme.tertiary
            ),
        ) {
            Text(text = "Logout")
        }
    }
}