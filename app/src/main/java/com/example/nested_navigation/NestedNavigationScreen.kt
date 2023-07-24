package com.example.nested_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

//splash --> sign in --> sign up --> dashboard --> profile
//splash --> register(nested navigation of sign in and sign up) --> dashboard --> profile

@Composable
fun NestedNavigationScreen() {

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = NestedScreen.Splash.route) {
        composable(NestedScreen.Splash.route) {
            SplashScreen()
        }

        //nested navigation

        navigation(
            route = NestedScreen.Register.route,
            startDestination = NestedScreen.Register.SignUp.route
        ) {
            composable(NestedScreen.Register.SignUp.route) {
                SignUpScreen()
            }
            composable(NestedScreen.Register.SignIn.route) {
                SignInScreen()
            }
        }

        composable(NestedScreen.Profile.route) {
            ProfileScreen()
        }
    }

}


@Composable
fun SplashScreen() {

}

@Composable
fun SignUpScreen() {

}

@Composable
fun SignInScreen() {

}

@Composable
fun ProfileScreen() {

}

sealed class NestedScreen(val route: String) {

    object Splash : NestedScreen("splash")
    object Register : NestedScreen("register") {
        object SignUp : NestedScreen("signup")
        object SignIn : NestedScreen("signin")
    }

    object Profile : NestedScreen("profile")
}

