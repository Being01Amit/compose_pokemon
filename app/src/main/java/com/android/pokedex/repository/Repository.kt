package com.android.pokedex.repository

import com.android.pokedex.remote.responses.PokemonListResponse
import com.android.pokedex.remote.responses.PokemonResponse
import com.android.pokedex.utils.Resource

interface Repository {
    suspend fun getPokemonList(limit: Int, offSet: Int): Resource<PokemonListResponse>
    suspend fun getPokemonInfo(name: String): Resource<PokemonResponse>
}