package com.android.pokedex.remote.api

import com.android.pokedex.remote.responses.PokemonListResponse
import com.android.pokedex.remote.responses.PokemonResponse
import com.android.pokedex.utils.CommonKeys.POKEMON_LIST
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeAPI {
    @GET(POKEMON_LIST)
    suspend fun getPokemonList(
        @Query("limit") limit : Int,
        @Query("offset") offSet : Int
    ) : PokemonListResponse

    @GET("$POKEMON_LIST/{name}")
    suspend fun getPokemonDetail(
        @Path("name") name : String
    ) : PokemonResponse
}