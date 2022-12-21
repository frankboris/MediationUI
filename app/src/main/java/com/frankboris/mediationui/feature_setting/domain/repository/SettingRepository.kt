package com.frankboris.mediationui.feature_setting.domain.repository

import com.frankboris.mediationui.feature_setting.data.AppSettings
import com.frankboris.mediationui.feature_setting.data.AppTheme
import com.frankboris.mediationui.feature_setting.data.Language
import kotlinx.coroutines.flow.Flow

interface SettingRepository {
    fun getAppSettings(): Flow<AppSettings>

    suspend fun setAppTheme(theme: AppTheme)

    suspend fun setAppLanguage(language: Language)

    suspend fun setSecondaryColor(secondary: Long)
}