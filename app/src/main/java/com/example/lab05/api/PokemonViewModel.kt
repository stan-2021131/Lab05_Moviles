package com.example.lab05.api

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab05.model.PokemonD
import kotlinx.coroutines.launch

class PokemonViewModel: ViewModel() {
    var pokemonList = mutableStateListOf<PokemonD>()
        private set

    var isLoading by mutableStateOf(true)
    var errorMessage by mutableStateOf("")

    init {
        fetchPokemon()
    }

    private fun fetchPokemon(){
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getPokemon() //Hace la llamada al api para obtener todos los pokemones
                val list = response.results

                list.forEach{ pokemon -> //Por cada pokemon encontrado busca sus detalles
                    val detail = RetrofitClient.apiService.getPokemonD(pokemon.name)
                    pokemonList.add(detail) //Agrega los pokemon a un listado junto con sus detalles
                }
                isLoading = false
            }catch (e: Exception){
                errorMessage = "Error: ${e.localizedMessage}"
                isLoading = false
            }
        }
    }
}