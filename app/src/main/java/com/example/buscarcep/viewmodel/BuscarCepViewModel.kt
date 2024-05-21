package com.example.buscarcep.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buscarcep.listener.RespostaApi
import com.example.buscarcep.repositorio.Repositorio
import kotlinx.coroutines.launch
import javax.inject.Inject

class BuscarCepViewModel @Inject constructor(private val repositorio: Repositorio): ViewModel() {

    fun respostaApi(cep: String, respostaApi: RespostaApi) {

        viewModelScope.launch {
            repositorio.respostaApi(cep, respostaApi)
        }

    }

}