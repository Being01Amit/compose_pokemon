@file:OptIn(ExperimentalCoilApi::class)

package com.android.pokedex.ui.pokemonListUI

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.android.pokedex.R
import com.android.pokedex.data.models.PokemonListEntry
import com.android.pokedex.ui.theme.RobotoCondensed
import com.android.pokedex.utils.Routes.POKEMON_DETAIL_SCREEN
import com.android.pokedex.viewModel.PokemonListViewModel


@Composable
fun PokemonListUI(
    navController: NavController?,
    viewModel: PokemonListViewModel = hiltViewModel<PokemonListViewModel>()
) {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(
                    id = R.drawable.ic_international_pok_mon_logo
                ),
                contentDescription = "pokemon",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterHorizontally)
            )
            SearchBar(
                hint = "Searching...",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 16.dp)
            ) {
                viewModel.searchPokemon(it)
            }
            Spacer(modifier = Modifier.height(16.dp))
            PokeList(navController = navController)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenPreview() {
    PokemonListUI(navController = null)
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    Box(modifier = modifier) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged {
                    isHintDisplayed = !it.hasFocus && text.isNotEmpty()
                }
                .animateContentSize()
        )
        if (isHintDisplayed) Text(
            text = hint,
            color = Color.LightGray,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 12.dp)
        )
    }
}


@Composable
fun PokemonEntry(
    entry: PokemonListEntry,
    navController: NavController?,
    modifier: Modifier = Modifier,
    viewModel: PokemonListViewModel = hiltViewModel<PokemonListViewModel>()
) {
    val defaultDominantColor = MaterialTheme.colorScheme.surface
    var dominantColor by remember {
        mutableStateOf(defaultDominantColor)
    }
    Box(
        contentAlignment = Center,
        modifier = modifier
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .background(
                Brush.verticalGradient(
                    listOf(
                        dominantColor,
                        defaultDominantColor
                    )
                )
            )
            .clickable {
                navController?.navigate("$POKEMON_DETAIL_SCREEN/${dominantColor.toArgb()}/${entry.pokemonName}")
            }
    ) {
        Column {
            val imageModel = ImageRequest.Builder(LocalContext.current)
                .data(data = entry.imageUrl)
                .crossfade(true)
                .build()

            AsyncImage(
                model = imageModel,
                contentDescription = entry.pokemonName,
                onSuccess = {
                    viewModel.calDominantColor(it.result.drawable) { color ->
                        dominantColor = color
                    }
                },
                modifier = Modifier
                    .size(150.dp)
                    .align(CenterHorizontally)
            )
            Text(
                text = entry.pokemonName,
                fontFamily = RobotoCondensed,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun PokeDexRow(
    rowIndex: Int,
    entries: List<PokemonListEntry>,
    navController: NavController?
) {
    Column {
        Row {
            PokemonEntry(
                entry = entries[rowIndex * 2],
                navController = navController,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            if (entries.size >= rowIndex * 2 + 2) {
                PokemonEntry(
                    entry = entries[rowIndex * 2 + 1],
                    navController = navController,
                    modifier = Modifier.weight(1f)
                )
            } else {
                Spacer(modifier = Modifier.weight(1f))
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
    }

}

@Composable
fun PokeList(
    navController: NavController?,
    pokeViewModel: PokemonListViewModel = hiltViewModel<PokemonListViewModel>()
) {
    val pokeList by remember { pokeViewModel.pokemonList }
    val endReached by remember { pokeViewModel.isEndReached }
    val loadError by remember { pokeViewModel.loadError }
    val isLoading by remember { pokeViewModel.isLoading }
    val isSearching by remember { pokeViewModel.isSearching }
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        val itemCount = if (pokeList.size % 2 == 0) pokeList.size / 2 else pokeList.size / 2 + 1
        items(itemCount) {
            if (it >= itemCount - 1 && !endReached && !isLoading && !isSearching) pokeViewModel.loadPokemonPaginated()
            PokeDexRow(
                rowIndex = it,
                entries = pokeList,
                navController = navController
            )
        }
    }
    Box(
        contentAlignment = Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if (isLoading) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        }
        if (loadError.isNotEmpty()) {
            RetrySection(error = loadError) {
                pokeViewModel.loadPokemonPaginated()
            }
        }
    }
}

@Composable
fun RetrySection(
    error: String,
    onRetry: () -> Unit
) {
    Column {
        Text(
            error, color = Color.Red, fontSize = 18.sp, textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { onRetry() },
            modifier = Modifier.align(CenterHorizontally)
        ) {
            Text(text = "Retry")
        }
    }
}