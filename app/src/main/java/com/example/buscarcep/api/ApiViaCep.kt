package com.example.buscarcep.api

import com.example.buscarcep.model.Endereco
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiViaCep {

    @GET("ws/{cep}/json")
    fun setEndereco(@Path("cep") cep: String): Call<Endereco>

}
