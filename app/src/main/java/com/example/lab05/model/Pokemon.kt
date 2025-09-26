package com.example.lab05.model

data class Pokemon(
    val name: String,
    val url: String
)

data class PokemonResponse(
    val results: List<Pokemon>
)

data class PokemonD(
    val name: String,
    val sprites: Sprites
)

data class Sprites(
    val front_default: String,
    val back_default: String,
    val front_shiny: String,
    val back_shiny: String
)
