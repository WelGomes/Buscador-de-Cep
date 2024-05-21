package com.example.buscarcep.listener

interface RespostaApi {

    fun onSucess(logradouro: String, bairro: String, cidade: String, estado: String)
    fun onFailure(erro: String)

}