package com.frankboris.mediationui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.frankboris.mediationui.feature_setting.presentation.SettingsScreen
import com.frankboris.mediationui.ui.screens.FeatureDetailsScreen

object MainDestinations {
    const val HOME_SCREEN = "main_screen"
    const val SETTING_SCREEN = "setting_screen"
    const val FEATURE_DETAILS_SCREEN = "feature_details_screen"
}
const val COURSE_DETAIL_ID_KEY = "courseId"

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestinations.HOME_SCREEN
) {
    val actions = remember(navController) { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        navigation(
            route = MainDestinations.HOME_SCREEN,
            startDestination = HomeTabs.HOME_TAB.route
        ) {
            homeNavGraph(navController, modifier, goToSettings = {
                navController.navigate(MainDestinations.SETTING_SCREEN)
            })
        }
        composable(MainDestinations.SETTING_SCREEN){
            SettingsScreen(navController = navController)
        }
        composable(
            "${MainDestinations.FEATURE_DETAILS_SCREEN}/{$COURSE_DETAIL_ID_KEY}",
            arguments = listOf(
                navArgument(COURSE_DETAIL_ID_KEY) { type = NavType.LongType }
            )
        ) { backStackEntry: NavBackStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val currentCourseId = arguments.getLong(COURSE_DETAIL_ID_KEY)
            FeatureDetailsScreen(
                onBackClick = { actions.upPress(backStackEntry) }
            )
        }
    }
}

class MainActions(navController: NavHostController) {
    // Used from HOME_ROUTE
    val openCourse = { newCourseId: Long, from: NavBackStackEntry ->
        // In order to discard duplicated navigation events, we check the Lifecycle
        if (from.lifecycleIsResumed()) {
            navController.navigate("${MainDestinations.FEATURE_DETAILS_SCREEN}/$newCourseId")
        }
    }

    // Used from FEATURE_DETAILS_SCREEN
    val relatedCourse = { newCourseId: Long, from: NavBackStackEntry ->
        // In order to discard duplicated navigation events, we check the Lifecycle
        if (from.lifecycleIsResumed()) {
            navController.navigate("${MainDestinations.FEATURE_DETAILS_SCREEN}/$newCourseId")
        }
    }

    // Used from FEATURE_DETAILS_SCREEN
    val upPress: (from: NavBackStackEntry) -> Unit = { from ->
        // In order to discard duplicated navigation events, we check the Lifecycle
        if (from.lifecycleIsResumed()) {
            navController.navigateUp()
        }
    }
}

/**
 * If the lifecycle is not resumed it means this NavBackStackEntry already processed a nav event.
 *
 * This is used to de-duplicate navigation events.
 */
private fun NavBackStackEntry.lifecycleIsResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED