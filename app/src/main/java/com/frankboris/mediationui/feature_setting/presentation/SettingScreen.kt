package com.frankboris.mediationui.feature_setting.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.frankboris.mediationui.R
import com.frankboris.mediationui.feature_setting.data.AppSettings
import com.frankboris.mediationui.feature_setting.data.AppTheme
import com.frankboris.mediationui.feature_setting.presentation.components.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.frankboris.mediationui.feature_setting.data.AppColors
import com.frankboris.mediationui.feature_setting.data.Language
import com.frankboris.mediationui.feature_setting.domain.util.SettingUtil

@Composable
fun SettingsScreen(
    navController: NavHostController,
    viewModel: SettingViewModel = hiltViewModel(),
) {
    val appSettings = viewModel.appSettings.collectAsState(initial = AppSettings()).value

    Scaffold(
        topBar = {
            SettingTopBar(
                title = stringResource(R.string.settings),
                onBackClick = { navController.navigateUp() }
            )
        },
        modifier = Modifier.statusBarsPadding()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            SettingHeader("Apparence")
            SettingThemeSelect(
                isDark = appSettings.appTheme === AppTheme.DARK,
                toggleAppTheme = {
                    viewModel.setAppTheme(
                        when {
                            appSettings.appTheme === AppTheme.DARK -> AppTheme.LIGHT
                            else -> AppTheme.DARK
                        }
                    )
                }
            )
            SettingLanguageSelect(
                title = stringResource(R.string.display_language),
                dialogTitle = "Choisir une langue",
                description = SettingUtil.getLanguageName(appSettings.language),
                value = appSettings.language,
                options = Language.values().toList(),
                onSelectionChange = { viewModel.setAppLanguage(it) }
            )
            SettingColorSelect(
                title = "Couleur principale",
                description = "Couleur d'affichage des titres",
                dialogTitle = "Choisir une couleur",
                value = appSettings.secondary,
                options = AppColors,
                onSelectionChange = { }
            )
            SettingColorSelect(
                title = "Couleur secondaire",
                description = "Couleur d'affichage des sous-titres",
                dialogTitle = "Choisir une couleur",
                value = appSettings.secondary,
                options = AppColors,
                onSelectionChange = { viewModel.setSecondaryColor(it) }
            )
            SettingHeader("Communication")
            SettingItem(
                left = {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        modifier = Modifier.size(30.dp),
                        contentDescription = "backIcon"
                    )
                },
                title = "Partager",
                description = "Partagez votre expérience",
            )
            SettingItem(
                left = {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        modifier = Modifier.size(30.dp),
                        contentDescription = "backIcon"
                    )
                },
                title = "A propos",
            )
            SettingItem(
                left = {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        modifier = Modifier.size(30.dp),
                        contentDescription = "backIcon"
                    )
                },
                title = "Donnez votre avis",
            )
        }
    }
}
