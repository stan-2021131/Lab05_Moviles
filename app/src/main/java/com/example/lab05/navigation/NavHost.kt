package com.example.lab05.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lab05.R
import com.example.lab05.screens.PokemonDetailScreen
import com.example.lab05.screens.PokemonListScreen
import com.example.lab05.api.PokemonViewModel

@Composable
fun AppNavigation(viewModel: PokemonViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.PokemonList){
        composable(Routes.PokemonList){
            PokemonListScreen(viewModel){ selectedPokemon ->
                navController.navigate("${Routes.PokemonDetail}/${selectedPokemon.name}")
            }
        }

        composable(
            route = "${Routes.PokemonDetail}/{pokemonName}",
            arguments = listOf(navArgument("pokemonName") {type = NavType.StringType})
        ){backStackEntry->
            val pokemonName = backStackEntry.arguments?.getString("pokemonName") ?: return@composable

            val selectedPokemon = viewModel.pokemonList.find {it.name == pokemonName}
            selectedPokemon?.let {
                PokemonDetailScreen(pokemon = it){
                    navController.popBackStack()
                }
            }?: Text(stringResource(R.string.PK404))
        }
    }
}