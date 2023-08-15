package com.rahdeva.bencanaapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.loopj.android.http.BuildConfig
import com.rahdeva.bencanaapp.data.DisasterRepositoryImpl
import com.rahdeva.bencanaapp.data.api.ApiService
import com.rahdeva.bencanaapp.domain.repository.DisasterRepository
import com.rahdeva.bencanaapp.domain.usecase.DisasterUseCase
import com.rahdeva.bencanaapp.domain.usecase.DisasterUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient{
        val interceptor = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
        }

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://data.petabencana.id/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }


    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(service: ApiService): DisasterRepository{
        return DisasterRepositoryImpl(service)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: DisasterRepository): DisasterUseCase{
        return DisasterUseCaseImpl(repository)
    }


}