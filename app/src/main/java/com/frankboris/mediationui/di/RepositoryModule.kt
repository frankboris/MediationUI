package com.frankboris.mediationui.di

import androidx.datastore.core.DataStore
import com.frankboris.mediationui.datasource.DbDataSource
import com.frankboris.mediationui.datasource.RestDataSource
import com.frankboris.mediationui.feature_code.data.repository.LocalRepositoryImpl
import com.frankboris.mediationui.feature_code.data.repository.RemoteRepositoryImpl
import com.frankboris.mediationui.feature_code.domain.repository.LocalRepository
import com.frankboris.mediationui.feature_code.domain.repository.RemoteRepository
import com.frankboris.mediationui.feature_setting.data.AppSettings
import com.frankboris.mediationui.feature_setting.data.repository.SettingRepositoryImpl
import com.frankboris.mediationui.feature_setting.domain.repository.SettingRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Reusable
    internal fun providesRemoteRepository(
        api: RestDataSource
    ): RemoteRepository {
        return RemoteRepositoryImpl(api)
    }

    @Provides
    @Reusable
    internal fun providesLocalRepository(
        db: DbDataSource
    ): LocalRepository {
        return LocalRepositoryImpl(db.codeDao())
    }

    @Provides
    @Reusable
    internal fun providesSettingRepository(
        dataStore: DataStore<AppSettings>
    ): SettingRepository {
        return SettingRepositoryImpl(dataStore)
    }
}