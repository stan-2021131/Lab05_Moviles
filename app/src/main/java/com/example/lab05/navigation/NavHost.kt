package com.example.lab05.navigation

import PokemonListScreen
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lab05.R
import com.example.lab05.ui.screens.PokemonDetailScreen
import com.example.lab05.ui.viewModel.PokemonViewModel

@Composable
fun AppNavigation(viewModel: PokemonViewModel) {
    val navController = rememberNavController()

    val pokemonList by viewModel.pokemonList.collectAsState()

    NavHost(navController = navController, startDestination = Routes.PokemonList) {
        composable(Routes.PokemonList) {
            PokemonListScreen(viewModel) { selectedPokemon ->
                navController.navigate("${Routes.PokemonDetail}/${selectedPokemon.name}")
            }
        }

        composable(
            route = "${Routes.PokemonDetail}/{pokemonName}",
            arguments = listOf(navArgument("pokemonName") { type = NavType.StringType })
        ) { backStackEntry ->
            val pokemonName = backStackEntry.arguments?.getString("pokemonName") ?: return@composable

            val selectedPokemon = pokemonList.find { it.name == pokemonName }
            selectedPokemon?.let { pokemon ->
                PokemonDetailScreen(pokemon = pokemon) {
                    navController.popBackStack()
                }
            } ?: Text(stringResource(R.string.PK404))
        }
    }
}