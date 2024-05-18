package com.android.pokedex

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.android.pokedex.ui.pokemonDetailScreen.PokemonDetailScreen
import com.android.pokedex.ui.pokemonListScreen.PokemonListUI
import com.android.pokedex.ui.theme.PokeDexTheme
import com.android.pokedex.utils.CommonKeys.BASE_URL
import com.android.pokedex.utils.CommonKeys.POKEMON_LIST
import com.android.pokedex.utils.Routes.POKEMON_DETAIL_SCREEN
import com.android.pokedex.utils.Routes.POKEMON_LIST_SCREEN
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getFuelNetworkCall()
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
                            it.arguments?.getString("pokemon_name")
                        }

                        PokemonDetailScreen(
                            dominatorColor = dominantColor,
                            pokemonName = pokemonName?.lowercase(Locale.ROOT) ?: "Pokemon",
                            navController = navController
                        )

                    }

                }
            }
        }
    }

    private fun getFuelNetworkCall() {
        Fuel.get(BASE_URL + POKEMON_LIST)
            .response { request, response, result ->
                showLogs(request.body)
                /*showLogs(response.toString())
               showLogs(result.toString())*/

                when (result) {
                    is Result.Success -> {
                        showLogs(response)
                        showLogs(response.body().asString("string"))
                        showLogs(response.data)
                    }

                    is Result.Failure -> {
                        showLogs(response.data)
                        showLogs(response.body())
                    }
                }
            }
    }

    private fun <T> showLogs(message: T) = Log.d("TAG----->", message.toString())
}
