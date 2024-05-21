package com.example.buscarcep.view


import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.buscarcep.componentes.Botao
import com.example.buscarcep.componentes.CaixaTexto
import com.example.buscarcep.listener.RespostaApi
import com.example.buscarcep.ui.theme.Teal700
import com.example.buscarcep.ui.theme.WHITE
import com.example.buscarcep.viewmodel.BuscarCepViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BuscarCep(navController: NavController, viewModel: BuscarCepViewModel = hiltViewModel()) {

    val context = LocalContext.current

    var inputcep by remember { mutableStateOf("") }
    var inputlogradouro by remember { mutableStateOf("") }
    var inputbairro by remember { mutableStateOf("") }
    var inputcidade by remember { mutableStateOf("") }
    var inputestado by remember { mutableStateOf("") }


    Scaffold(
        topBar = {
            androidx.compose.material.TopAppBar(
                backgroundColor = Teal700,
                title = {
                    Text(
                        text = "Buscador de Cep",
                        fontSize = 18.sp,
                        color = WHITE
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 100.dp)
            ) {

                CaixaTexto(
                    value = inputcep,
                    onValue = {
                        inputcep = it
                    },
                    label = "Cep",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier
                        .width(200.dp)
                        .padding(start = 20.dp, top = 0.dp, end = 20.dp, bottom = 0.dp)
                )

                Botao(
                    onClick = {
                        viewModel.respostaApi(inputcep, object : RespostaApi {
                            override fun onSucess(
                                logradouro: String,
                                bairro: String,
                                cidade: String,
                                estado: String
                            ) {
                                inputlogradouro = logradouro
                                inputbairro = bairro
                                inputcidade = cidade
                                inputestado = estado
                            }

                            override fun onFailure(erro: String) {
                                Toast.makeText(context, erro, Toast.LENGTH_SHORT).show()
                            }

                        })
                    },
                    texto = "Buscar Cep",
                    modifier = Modifier
                        .height(65.dp)
                        .padding(start = 0.dp, top = 8.dp, end = 20.dp, bottom = 0.dp)
                )

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                CaixaTexto(
                    value = inputlogradouro,
                    onValue = {
                        inputlogradouro = it
                    },
                    label = "Logradouro",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 0.dp)

                )

                CaixaTexto(
                    value = inputbairro,
                    onValue = {
                        inputbairro = it
                    },
                    label = "Bairro",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 0.dp)

                )

                CaixaTexto(
                    value = inputcidade,
                    onValue = {
                        inputcidade = it
                    },
                    label = "Cidade",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 0.dp)

                )

                CaixaTexto(
                    value = inputestado,
                    onValue = {
                        inputestado = it
                    },
                    label = "Estado",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    modifier = Modifier
                        .width(150.dp)
                        .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 0.dp)

                )

                Botao(
                    onClick = {
                        if(inputcep.isEmpty() || inputbairro.isEmpty() || inputlogradouro.isEmpty() || inputcidade.isEmpty() || inputestado.isEmpty()) {
                            Toast.makeText(context, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                        } else {
                            navController.navigate("detalhesEndereco/${inputlogradouro}/${inputbairro}/${inputcidade}/${inputestado}")
                        }
                    },
                    texto = "Avançar",
                    modifier = Modifier
                        .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 0.dp)
                        .height(55.dp)
                        .width(110.dp)
                )

            }
        }
    }

}