package com.frankboris.mediationui.di

import android.content.Context
import androidx.datastore.dataStore
import androidx.room.Room
import com.frankboris.mediationui.datasource.DbDataSource
import com.frankboris.mediationui.datasource.RestDataSource
import com.frankboris.mediationui.feature_setting.data.AppSettingsSerializer
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    private val Context.dataStore by dataStore("app-settings.json", AppSettingsSerializer)

    @Provides
    @Reusable
    fun provideDataStore(@ApplicationContext context: Context) = context.dataStore

    @Provides
    @Reusable
    fun provideRestDataSource(): RestDataSource {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        val httpClient: OkHttpClient.Builder  = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        return Retrofit.Builder()
            .baseUrl(RestDataSource.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create(RestDataSource::class.java)
    }

    @Reusable
    @Provides
    fun dbDataSource(@ApplicationContext context: Context): DbDataSource {
        return Room.databaseBuilder(context, DbDataSource::class.java, DbDataSource.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}