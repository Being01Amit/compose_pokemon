package com.android.pokedex.viewModel

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import com.android.pokedex.data.models.PokemonListEntry
import com.android.pokedex.repository.Repository
import com.android.pokedex.utils.CommonKeys.PAGE_SIZE
import com.android.pokedex.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private var currentPage = 0
    var pokemonList = mutableStateOf<List<PokemonListEntry>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var isEndReached = mutableStateOf(false)

    private var cachedPokemon = listOf<PokemonListEntry>()
    private var isSearchStart = true
    var isSearching = mutableStateOf(false)

    init {
        loadPokemonPaginated()
    }

    /**
     * This function use for get the Dominant color of the Pokemon and set the background of that pokemon
     * */
    fun calDominantColor(drawable: Drawable, onFinished: (Color) -> Unit) {
        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
        Palette.from(bmp).generate { palette ->
            palette?.dominantSwatch?.rgb?.let { colorValue ->
                onFinished(Color(colorValue))
            }
        }
    }

    fun loadPokemonPaginated() {
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.getPokemonList(PAGE_SIZE, currentPage * 2)
            when (result) {
                is Resource.Success -> {
                    isEndReached.value = currentPage * PAGE_SIZE >= result.data!!.count
                    val pokeDexEntry = result.data.results.mapIndexed { index, entry ->
                        val pokeNumber = if (entry.url.endsWith("/")) {
                            entry.url.dropLast(1).takeLastWhile { it.isDigit() }
                        } else {
                            entry.url.takeLastWhile { it.isDigit() }
                        }
                        val url =
                            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokeNumber}.png"
                        PokemonListEntry(
                            pokemonName = entry.name.capitalize(java.util.Locale.ROOT),
                            imageUrl = url,
                            pokemonNumber = pokeNumber.toInt()
                        )
                    }
                    currentPage++
                    loadError.value = ""
                    isLoading.value = false
                    pokemonList.value = pokeDexEntry
                }

                is Resource.Error -> {
                    loadError.value = result.message!!
                    isLoading.value = false
                }

                else -> {

                }
            }
        }
    }


    fun searchPokemon(query: String) {
        val listToSearch = if (isSearchStart) pokemonList.value else cachedPokemon
        viewModelScope.launch(Dispatchers.Default) {
            if (query.isEmpty()) {
                pokemonList.value = cachedPokemon
                isSearching.value = false
                isSearchStart = true
                return@launch
            }
            val result = listToSearch.filter {
                it.pokemonName.contains(
                    query.trim(),
                    ignoreCase = true
                ) || it.pokemonNumber.toString() == query.trim()
            }

            if (isSearchStart) {
                cachedPokemon = pokemonList.value
                isSearchStart = false
            }
            pokemonList.value = result
            isSearching.value = true
        }
    }

}