package com.example.nabarro.meusfilmes.Views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import com.example.nabarro.meusfilmes.adapter.FilmListAdapter
import com.example.nabarro.meusfilmes.Model.Filmes
import com.example.nabarro.meusfilmes.R
import com.example.nabarro.meusfilmes.Retrofit.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_listagem.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmesListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem)

        val call = RetrofitInitializer().noteService().list()

        call.enqueue(object: Callback<List<Filmes>?> {
            override fun onResponse(call: Call<List<Filmes>?>?,
                                    response: Response<List<Filmes>?>?) {
                response?.body()?.let {
                    val notes: List<Filmes> = it
                    configureList(notes)
                }
            }

            override fun onFailure(call: Call<List<Filmes>?>?,
                                   t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })

    }

    private fun configureList(notes: List<Filmes>) {

        val layoutManager = LinearLayoutManager( this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        recycler_films.layoutManager = layoutManager

        val adapter = FilmListAdapter(notes, this)
        recycler_films.adapter = adapter

    }
}