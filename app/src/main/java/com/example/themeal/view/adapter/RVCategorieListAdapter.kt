package com.example.themeal.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themeal.R
import com.example.themeal.databinding.ItemCategoriaBinding
import com.example.themeal.model.Categoria
import com.example.themeal.view.fragments.CategoriaListFragment


class RVCategoriaListAdapter( var categoria:List<Categoria>, val onClick:(Categoria) ->Unit): RecyclerView.Adapter<CategoriaVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaVH {
        val binding = ItemCategoriaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriaVH(binding,onClick)
    }

    override fun getItemCount(): Int =categoria.size

    override fun onBindViewHolder(holder: CategoriaVH, position: Int) {
        holder.bind(categoria[position],holder.itemView.context)
        /*
        with(holder){
            with(categoria[position]){
                Glide.with(holder.itemView.context).load(strCategoryThumb).into(binding.imageView)
            }
        }

         */
    }

}
class CategoriaVH( val binding:ItemCategoriaBinding, val onClick: (Categoria) -> Unit): RecyclerView.ViewHolder(binding.root){
    fun bind(categoria: Categoria,context:Context) {

        Glide.with(context).load(categoria.strCategoryThumb).into(binding.imageView)
        //Glide.with(this).load(categoria.strCategoryThumb).into(binding.imageView)

        //binding.imageView.setImageURI(categoria.strCategoryThumb)
        binding.txtName.text = categoria.strCategory
        binding.txtDetail.text = categoria.strCategoryDescription
        binding.root.setOnClickListener{
            onClick(categoria)
        }

    }

}