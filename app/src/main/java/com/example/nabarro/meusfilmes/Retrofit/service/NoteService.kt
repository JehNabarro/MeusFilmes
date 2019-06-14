package com.example.nabarro.meusfilmes.Retrofit.service

import com.example.nabarro.meusfilmes.Model.Filmes
import retrofit2.Call
import retrofit2.http.GET

interface NoteService {
    @GET("filmes")

    fun list() : Call<List<Filmes>>
}