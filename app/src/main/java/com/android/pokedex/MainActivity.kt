package com.android.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.android.pokedex.ui.pokemonListUI.PokemonListUI
import com.android.pokedex.ui.theme.PokeDexTheme
import com.android.pokedex.utils.Routes.POKEMON_DETAIL_SCREEN
import com.android.pokedex.utils.Routes.POKEMON_LIST_SCREEN
import com.android.pokedex.viewModel.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeDexTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = POKEMON_LIST_SCREEN) {
                    composable(POKEMON_LIST_SCREEN) {
                        PokemonListUI(navController = navController)
                    }

                    composable("$POKEMON_DETAIL_SCREEN/{dominantColor}/{pokemon_name}",
                        arguments = listOf(
                            navArgument("dominantColor") {
                                type = NavType.IntType
                            },
                            navArgument("pokemon_name") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val dominantColor = remember {
                            val color = it.arguments?.getInt("dominantColor")
                            color?.let { Color(it) } ?: Color.White
                        }
                        val pokemonName = remember {
                            it.arguments?.getInt("pokemon_name")
                        }

                    }

                }
            }
        }
    }
}
