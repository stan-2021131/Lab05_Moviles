package com.example.lab05.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab05.data.repository.PokemonRepository
import com.example.lab05.model.PokemonD
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonViewModel(private val repository: PokemonRepository) : ViewModel() {

    private val _pokemonList = MutableStateFlow<List<PokemonD>>(emptyList())
    val pokemonList: StateFlow<List<PokemonD>> = _pokemonList.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: StateFlow<String> = _errorMessage.asStateFlow()

    init {
        fetchPokemon()
    }

    private fun fetchPokemon() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _errorMessage.value = ""

                val response = repository.getPokemonList()
                val detailedPokemonList = mutableListOf<PokemonD>()

                response.results.forEach { pokemon ->
                    repository.getPokemonDetails(pokemon.name).collect { details ->
                        detailedPokemonList.add(details)
                    }
                }

                _pokemonList.value = detailedPokemonList
                _isLoading.value = false

            } catch (e: Exception) {
                _errorMessage.value = "Error: ${e.localizedMessage ?: "Unknown error"}"
                _isLoading.value = false
            }
        }
    }
}