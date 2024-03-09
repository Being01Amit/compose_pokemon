package com.android.pokedex.di

import com.android.pokedex.remote.api.PokeAPI
import com.android.pokedex.repository.Repository
import com.android.pokedex.repository.RepositoryImplementation
import com.android.pokedex.utils.CommonKeys.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokemonRepository(
        api: PokeAPI
    ): Repository {
        return RepositoryImplementation(api)
    }

    @Singleton
    @Provides
    fun providePokeAPI(): PokeAPI {
        val client: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(PokeAPI::class.java)
    }
}