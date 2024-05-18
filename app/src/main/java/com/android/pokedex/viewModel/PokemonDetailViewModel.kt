package com.android.pokedex.viewModel

import androidx.lifecycle.ViewModel
import com.android.pokedex.remote.responses.PokemonResponse
import com.android.pokedex.repository.Repository
import com.android.pokedex.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    suspend fun getPokemonInfo(pokemonName : String): Resource<PokemonResponse>{
        return  repository.getPokemonInfo(pokemonName)
    }
}