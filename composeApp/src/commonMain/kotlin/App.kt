import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview

import ui.screens.HomeScreen
import ui.screens.LoginScreen
import ui.screens.RegistrationScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        Scaffold(Modifier.fillMaxWidth(), backgroundColor = Color.White) {
            NavHost(navController = navController, startDestination = "LoginScreen") {
                composable("HomeScreen") {
                    HomeScreen(navController = navController)
                }
                composable("LoginScreen") {
                    LoginScreen(
                        onLoginClick = {
                            navController.navigate("HomeScreen")
                        },
                        onRegisterClick = {
                            navController.navigate("RegistrationScreen")
                        },
                        onForgotPasswordClick = {}
                    )
                }
                composable("RegistrationScreen") {
                    RegistrationScreen(
                        onRegisterClick = {},
                        onBackClick = { navController.popBackStack() })
                }
            }
        }
    }
}