package com.example.pruebanisum.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebanisum.R
import com.example.pruebanisum.databinding.ViewLfBinding
import com.example.pruebanisum.db.model.Lf

class VarsAdapter(private val lf: ArrayList<Lf>) : RecyclerView.Adapter<VarsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ViewLfBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_lf, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTextLf.text = lf[position].lf
        holder.binding.tvTextFreq.text = "${lf[position].freq}"
        holder.binding.tvTextSince.text = "${lf[position].since}"
    }

    override fun getItemCount() = lf.size
}