package com.frankboris.mediationui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frankboris.mediationui.feature_setting.data.AppSettings
import com.frankboris.mediationui.feature_setting.data.AppTheme
import com.frankboris.mediationui.feature_setting.domain.repository.SettingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val settingRepository: SettingRepository
) : ViewModel() {
    private val _appSettings = settingRepository.getAppSettings()
    val appSettings: Flow<AppSettings> = _appSettings
    fun setAppTheme(appTheme: AppTheme) = viewModelScope.launch { settingRepository.setAppTheme(appTheme) }
}