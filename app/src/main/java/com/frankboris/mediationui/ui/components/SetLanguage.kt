package com.frankboris.mediationui.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import com.frankboris.mediationui.feature_setting.data.Language
import com.frankboris.mediationui.feature_setting.domain.util.SettingUtil
import java.util.*

@Composable
fun SetLanguage(language: Language = Language.FRENCH) {
    val locale = Locale(SettingUtil.getLanguageCode(language))
    val configuration = LocalConfiguration.current
    configuration.setLocale(locale)
    val resources = LocalContext.current.resources
    resources.updateConfiguration(configuration, resources.displayMetrics)
}