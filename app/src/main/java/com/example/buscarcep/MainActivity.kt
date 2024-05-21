package com.example.buscarcep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.buscarcep.ui.theme.BuscarCepTheme
import com.example.buscarcep.view.BuscarCep
import com.example.buscarcep.view.DetalhesEndereco
import com.example.buscarcep.viewmodel.BuscarCepViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuscarCepTheme {

                val navController: NavHostController = rememberNavController()
                val viewModel: BuscarCepViewModel = hiltViewModel()
                NavHost(
                    navController = navController,
                    startDestination = "buscarCep"
                ) {
                    composable("buscarCep") {
                        BuscarCep(navController)
                    }

                    composable(
                        "detalhesEndereco/{logradouro}/{bairro}/{cidade}/{estado}",
                        arguments = listOf(
                            navArgument("logradouto") {type = NavType.StringType },
                            navArgument("bairro") { type = NavType.StringType },
                            navArgument("cidade") { type = NavType.StringType },
                            navArgument("estado") { type = NavType.StringType }
                        )
                    ) {
                        DetalhesEndereco(
                            navController,
                            it.arguments?.getString("logradouro").toString(),
                            it.arguments?.getString("bairro").toString(),
                            it.arguments?.getString("cidade").toString(),
                            it.arguments?.getString("estado").toString()
                            )
                    }
                }
            }
        }
    }
}