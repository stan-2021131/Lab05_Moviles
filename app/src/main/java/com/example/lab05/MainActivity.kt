package com.example.lab05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab05.data.remote.RetrofitClient
import com.example.lab05.data.repository.PokemonRepository
import com.example.lab05.navigation.AppNavigation
import com.example.lab05.ui.viewModel.PokemonViewModel
import com.example.lab05.ui.viewmodel.PokemonViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val repository = PokemonRepository(RetrofitClient.apiService)
            val viewModelFactory = PokemonViewModelFactory(repository)

            val viewModel: PokemonViewModel = viewModel(
                factory = viewModelFactory
            )

            AppNavigation(viewModel)
        }
    }
}
