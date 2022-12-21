package com.frankboris.mediationui.feature_setting.data.repository

import androidx.datastore.core.DataStore
import com.frankboris.mediationui.feature_setting.data.AppSettings
import com.frankboris.mediationui.feature_setting.data.AppTheme
import com.frankboris.mediationui.feature_setting.data.Language
import com.frankboris.mediationui.feature_setting.domain.repository.SettingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class SettingRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<AppSettings>
) : SettingRepository {

    override fun getAppSettings(): Flow<AppSettings> {
        return dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(AppSettings())
            } else {
                throw exception
            }
        }.map { protoBuilder -> protoBuilder }
    }

    override suspend fun setAppTheme(theme: AppTheme) {
        dataStore.updateData { store ->
            store.copy(
                appTheme = when {
                    store.appTheme === AppTheme.LIGHT -> AppTheme.DARK
                    else -> AppTheme.LIGHT
                }
            )
        }
    }

    override suspend fun setAppLanguage(language: Language) {
        dataStore.updateData { store -> store.copy(language = language) }
    }

    override suspend fun setSecondaryColor(secondary: Long) {
        dataStore.updateData { store -> store.copy(secondary = secondary) }
    }
}