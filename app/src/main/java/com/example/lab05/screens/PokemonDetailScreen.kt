package com.example.lab05.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.lab05.R
import com.example.lab05.components.TopBar
import com.example.lab05.model.PokemonD

@Composable
fun PokemonDetailScreen(pokemon: PokemonD, onBack: () -> Unit){
    TopBar(pokemon.name.uppercase(), true, onBack)
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF212121)),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(4.dp))
            {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(stringResource(R.string.front_default), color = Color.White, modifier = Modifier.padding(top= 10.dp))
                    Image(painter = rememberAsyncImagePainter(pokemon.sprites.front_default), contentDescription = stringResource(R.string.front_default), modifier = Modifier.size(128.dp))
                }
            }

            Spacer(Modifier.width(8.dp))
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF212121)),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(4.dp))
            {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(stringResource(R.string.back_default), color = Color.White, modifier = Modifier.padding(top= 10.dp))
                    Image(painter = rememberAsyncImagePainter(pokemon.sprites.back_default), contentDescription = stringResource(R.string.back_default), modifier = Modifier.size(128.dp))
                }
            }

        }

        Spacer(Modifier.height(16.dp))

        Row {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF212121)), // fondo gris oscuro)
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(4.dp))
            {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(stringResource(R.string.front_shiny), color = Color.White, modifier = Modifier.padding(top= 10.dp))
                    Image(painter = rememberAsyncImagePainter(pokemon.sprites.front_shiny), contentDescription = stringResource(R.string.front_shiny), modifier = Modifier.size(128.dp))
                }
            }

            Spacer(Modifier.width(8.dp))
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF212121)),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(4.dp))
            {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(stringResource(R.string.back_shiny), color = Color.White, modifier = Modifier.padding(top= 10.dp))
                    Image(painter = rememberAsyncImagePainter(pokemon.sprites.back_shiny), contentDescription = stringResource(R.string.back_shiny), modifier = Modifier.size(128.dp))
                }
            }

        }
    }
}