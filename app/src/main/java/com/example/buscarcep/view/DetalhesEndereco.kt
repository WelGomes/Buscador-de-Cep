package com.example.buscarcep.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetalhesEndereco(
    navController: NavController,
    logradouro: String,
    bairro: String,
    cidade: String,
    estado: String
) {

    Column {
        Text(text = logradouro)
        Text(text = bairro)
        Text(text = cidade)
        Text(text = estado)
    }

}