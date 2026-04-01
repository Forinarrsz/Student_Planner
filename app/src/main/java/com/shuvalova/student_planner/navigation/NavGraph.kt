package com.shuvalova.student_planner.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.shuvalova.student_planner.ui_model.*

@Composable
fun StudentPlannerNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                onSubjectClick = { subjectId -> navController.navigate(Screen.Details.createRoute(subjectId))},
                onProfileClick = {
                    navController.navigate(Screen.Profile.route)
                },
                onSettingsClick = {
                    navController.navigate(Screen.Settings.route)
                }
            )
        }
        //discipline detalis
        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument("subjectId") {type = NavType.StringType}
            )
        ){
            backStackEntry ->
            val subjectId = backStackEntry.arguments?.getString("subjectId") ?:""
            DetailsScreen(
                subjectId = subjectId,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        //profile screen
        composable(route = Screen.Profile.route) {}
        //settings screen
        composable(route = Screen.Settings.route) {}

    }
}