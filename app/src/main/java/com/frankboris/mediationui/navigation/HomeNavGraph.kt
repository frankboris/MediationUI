package com.frankboris.mediationui.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.frankboris.mediationui.ui.screens.*

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    goToSettings: () -> Unit
) {
    composable(HomeTabs.HOME_TAB.route) {
        HomeScreen(onFeatureClick = {}, modifier = modifier, goToSettings = goToSettings)
    }
    composable(HomeTabs.MEDITATE_TAB.route) {
        MeditateScreen()
    }
    composable(HomeTabs.SLEEP_TAB.route) {
        SleepScreen(modifier)
    }
    composable(HomeTabs.MUSIC_TAB.route) {
        MusicScreen(modifier)
    }
    composable(HomeTabs.PROFILE_TAB.route) {
        ProfileScreen(modifier)
    }
}
