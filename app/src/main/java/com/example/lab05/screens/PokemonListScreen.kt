package com.example.lab05.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.lab05.R
import com.example.lab05.api.PokemonViewModel
import com.example.lab05.components.TopBar
import com.example.lab05.model.PokemonD
import java.util.Locale

@Composable
fun PokemonListScreen(viewModel: PokemonViewModel = PokemonViewModel(), onPokemonClick: (PokemonD)->Unit) {
    TopBar(stringResource(R.string.titlePKList), false, {})
    Column(
        modifier = Modifier.padding(top = 80.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        if(viewModel.isLoading){
            CircularProgressIndicator()
        }else if(viewModel.errorMessage.isNotEmpty()){
            Text("Error: ${viewModel.errorMessage}")
        }else{
            LazyColumn {
                items(viewModel.pokemonList){
                        pokemon ->
                    Card( modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { onPokemonClick(pokemon) }
                    ){
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.background(Color(0xFF212121)).fillMaxSize()
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(pokemon.sprites.front_default),
                                contentDescription = pokemon.name,
                                modifier = Modifier.size(64.dp)
                            )
                            Spacer(modifier = Modifier.size(64.dp))
                            Text(text = pokemon.name.capitalize(Locale.ROOT), style = MaterialTheme.typography.labelLarge, color = Color.White)
                        }
                    }
                }
            }
        }
    }
}