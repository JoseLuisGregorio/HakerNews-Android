package com.jose.hackernews.di

import com.jose.hackernews.BuildConfig
import com.jose.hackernews.data.network.HackerNewClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideHackerNewsApiClient(retrofit: Retrofit): HackerNewClient {
        return retrofit.create(HackerNewClient::class.java)
    }
}