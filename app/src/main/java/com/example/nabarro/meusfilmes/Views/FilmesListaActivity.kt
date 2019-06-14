package com.example.nabarro.meusfilmes.Views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import com.example.nabarro.meusfilmes.Adapter.FilmListAdapter
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
        val recyclerView = recycler_films
        recyclerView.adapter = FilmListAdapter(notes, this)
        val layoutManager = StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }
}