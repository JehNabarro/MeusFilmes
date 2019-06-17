package com.example.nabarro.meusfilmes.Retrofit

import com.example.nabarro.meusfilmes.Retrofit.service.NoteService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*


class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
            .baseUrl("http://encurtador.com.br")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun noteService(): NoteService {
        return retrofit.create(NoteService::class.java)
    }
}