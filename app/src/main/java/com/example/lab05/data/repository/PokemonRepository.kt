package com.example.lab05.data.repository

import com.example.lab05.data.remote.ApiService
import com.example.lab05.model.PokemonD
import com.example.lab05.model.PokemonResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonRepository(private val apiService: ApiService) {

    suspend fun getPokemonList(): PokemonResponse {
        return apiService.getPokemon()
    }

    fun getPokemonDetails(name: String): Flow<PokemonD> = flow {
        try {
            val pokemonDetail = apiService.getPokemonD(name)
            emit(pokemonDetail)
        } catch (e: Exception) {
            throw e
        }
    }
}