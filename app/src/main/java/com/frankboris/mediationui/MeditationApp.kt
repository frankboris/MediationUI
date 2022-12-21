package com.frankboris.mediationui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.frankboris.mediationui.feature_setting.data.AppSettings
import com.frankboris.mediationui.feature_setting.data.AppTheme
import com.frankboris.mediationui.navigation.HomeTabs
import com.frankboris.mediationui.navigation.NavGraph
import com.frankboris.mediationui.ui.components.SetLanguage
import com.frankboris.mediationui.ui.theme.MediationUITheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MeditationApp(
    viewModel: AppViewModel = hiltViewModel(),
) {
    val appSettings = viewModel.appSettings.collectAsState(initial = AppSettings()).value
    val tabs = remember { HomeTabs.values() }
    val systemUiController = rememberSystemUiController()
    val navController = rememberNavController()
    val darkTheme = appSettings.appTheme === AppTheme.DARK

    SetLanguage(appSettings.language)
    MediationUITheme(
        darkTheme = darkTheme,
        secondary = Color(appSettings.secondary)
    ) {
        systemUiController.setStatusBarColor(
            Color.Transparent,
            darkIcons = !darkTheme
        )
        systemUiController.setNavigationBarColor(
            Color.Transparent,
            darkIcons = !darkTheme
        )

        Scaffold(
            modifier = Modifier.background(MaterialTheme.colors.surface),
            bottomBar = { MyBottomBar(navController = navController, tabs) }
        ) { innerPadding ->
            NavGraph(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun MyBottomBar(navController: NavController, tabs: Array<HomeTabs>) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
        ?: HomeTabs.HOME_TAB.route

    val routes = remember { HomeTabs.values().map { it.route } }

    val navigationHeight: Dp =
        WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding() + 70.dp

    if (currentRoute in routes) {
        BottomNavigation(
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
            modifier = Modifier.height(navigationHeight)
        ) {
            tabs.forEach { tab ->
                BottomNavigationItem(
                    modifier = Modifier
                        .fillMaxHeight()
                        .navigationBarsPadding(),
                    icon = {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(
                                    when {
                                        (currentRoute != tab.route) -> Color.Transparent
                                        else -> MaterialTheme.colors.secondary
                                    }
                                )
                                .padding(7.5.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = tab.iconId),
                                contentDescription = stringResource(tab.title),
                                modifier = Modifier.size(
                                    when {
                                        (currentRoute == tab.route) -> 20.dp
                                        else -> 24.dp
                                    }
                                ),
                                tint = when {
                                    (currentRoute == tab.route) -> Color.White
                                    else -> MaterialTheme.colors.onSurface
                                }
                            )
                        }
                    },
                    label = {
                        Text(
                            text = stringResource(tab.title),
                            fontSize = 11.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = when {
                                (currentRoute == tab.route) -> MaterialTheme.colors.secondary
                                else -> MaterialTheme.colors.onSurface
                            }
                        )
                    },
                    selected = currentRoute == tab.route,
                    selectedContentColor = Color.White,
                    onClick = {
                        if (tab.route != currentRoute) {
                            navController.navigate(tab.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    alwaysShowLabel = true,
                )
            }
        }
    }
}