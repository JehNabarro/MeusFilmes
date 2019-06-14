package com.example.nabarro.meusfilmes.Retrofit

import com.example.nabarro.meusfilmes.Retrofit.service.NoteService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
            .baseUrl("http://api.themoviedb.org/3/movie/popular?api_key=a439c36c31622f0eef5cebc0dd6dbafd&language=pt-BR&page=1")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun noteService(): NoteService {
        return retrofit.create(NoteService::class.java)
    }
}