package com.android.pokedex.repository

import com.android.pokedex.remote.api.PokeAPI
import com.android.pokedex.remote.responses.PokemonListResponse
import com.android.pokedex.remote.responses.PokemonResponse
import com.android.pokedex.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class RepositoryImplementation @Inject constructor(
    private val api: PokeAPI
) : Repository {
    override suspend fun getPokemonList(limit: Int, offSet: Int): Resource<PokemonListResponse> {
        val response = try {
            api.getPokemonList(limit, offSet)
        } catch (e: Exception) {
            return Resource.Error(e.message.toString())
        }
        return Resource.Success(response)
    }

    override suspend fun getPokemonInfo(name: String): Resource<PokemonResponse> {
        val response = try {
            api.getPokemonDetail(name)
        } catch (e: Exception) {
            return Resource.Error(e.message.toString())
        }
        return Resource.Success(response)
    }
}