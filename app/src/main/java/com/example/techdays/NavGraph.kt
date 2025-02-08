package com.example.techdays

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

val WelcomeScreenRoute = "welcome"
val JournalScreenRoute = "journal"

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = WelcomeScreenRoute,
    ) {

        // Welcome Screen
        composable(WelcomeScreenRoute) {
            WelcomeScreen(
                onContinue = {
                    navController.navigate(JournalScreenRoute)
                },
            )
        }

        // Journal Screen
        composable(JournalScreenRoute) {
            JournalScreen()
        }

    }

}

@Preview
@Composable
fun NavGraphPreview() {
    NavGraph()
}