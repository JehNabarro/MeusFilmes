package com.example.nabarro.meusfilmes.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nabarro.meusfilmes.Model.Filmes
import com.example.nabarro.meusfilmes.R
import kotlinx.android.synthetic.main.line_list.view.*

class FilmListAdapter(private val notes: List<Filmes>,
                        private val context: Context) : RecyclerView.Adapter<FilmListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.setData(note)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.line_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(note: Filmes) {
            val title = itemView.tituloFilme
            val pontuacao = itemView.potuacaoFilme

            title.text = note.title
            pontuacao.text = note.vote_average
        }

        fun setData(note: Filmes?){

            itemView.tituloFilme.text = note!!.title
            itemView.potuacaoFilme.text = note!!.vote_average
        }
    }

}