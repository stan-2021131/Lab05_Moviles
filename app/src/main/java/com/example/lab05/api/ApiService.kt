package com.example.lab05.api

import com.example.lab05.model.Pokemon
import com.example.lab05.model.PokemonD
import com.example.lab05.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("pokemon")
    suspend fun getPokemon(@Query("limit") limit: Int = 100): PokemonResponse
    @GET("pokemon/{name}")
    suspend fun getPokemonD(@Path("name") name:String): PokemonD
}