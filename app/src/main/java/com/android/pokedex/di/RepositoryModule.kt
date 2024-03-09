package com.android.pokedex.di

import com.android.pokedex.remote.api.PokeAPI
import com.android.pokedex.repository.Repository
import com.android.pokedex.repository.RepositoryImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    fun bindRepository(api: PokeAPI): Repository {
        return RepositoryImplementation(api)
    }
}*/
