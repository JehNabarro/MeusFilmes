package com.example.nabarro.meusfilmes.Retrofit.service

import com.example.nabarro.meusfilmes.Model.Filmes
import retrofit2.Call
import retrofit2.http.GET

interface NoteService {
    @GET("/3/movie/popular")
    fun list() : Call<List<Filmes>>
}

