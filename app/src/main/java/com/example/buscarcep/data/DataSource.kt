package com.example.buscarcep.data

import com.example.buscarcep.api.ApiViaCep
import com.example.buscarcep.listener.RespostaApi
import com.example.buscarcep.model.Endereco
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class DataSource @Inject constructor(){

    private val retrofit: ApiViaCep = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://viacep.com.br/")
        .build()
        .create(ApiViaCep::class.java)

    fun respostaApi(cep: String, respostaApi: RespostaApi) {
        if(cep.isEmpty()) {
            respostaApi.onFailure("Preencha o campo de cep!")
        } else {
            retrofit.setEndereco(cep).enqueue(object : Callback<Endereco>{
                override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
                    if(response.code() == 200) {
                        val logradouro = response.body()?.logradouro.toString()
                        val bairro = response.body()?.bairro.toString()
                        val cidade = response.body()?.localidade.toString()
                        val estado = response.body()?.uf.toString()

                        respostaApi.onSucess(logradouro, bairro, cidade, estado)
                    } else {
                        respostaApi.onFailure("Cep invalido!")
                    }
                }

                override fun onFailure(call: Call<Endereco>, t: Throwable) {
                    respostaApi.onFailure("Erro inesperado!")
                }

            })
        }
    }

}