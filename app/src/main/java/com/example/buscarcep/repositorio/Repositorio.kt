package com.example.buscarcep.repositorio

import com.example.buscarcep.data.DataSource
import com.example.buscarcep.listener.RespostaApi
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repositorio @Inject constructor(private val dataSource: DataSource) {

    fun respostaApi(cep: String, respostaApi: RespostaApi) {
        dataSource.respostaApi(cep, respostaApi)
    }

}