package com.example.themeal.view.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

import com.example.themeal.R
import com.example.themeal.databinding.FragmentCategoriaDetailBinding
import com.example.themeal.model.Categoria


class CategoriaDetailFragment : Fragment() {
    private lateinit var binding: FragmentCategoriaDetailBinding
    val args:CategoriaDetailFragmentArgs by navArgs()
    private lateinit var categoria: Categoria
    private lateinit var viewModel: CategoriaDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoria = args.categoria
        viewModel = ViewModelProvider(requireActivity()).get(CategoriaDetailViewModel::class.java)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoriaDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.imgCategoria.setImageResource(R.drawable.logo)
        Glide.with(this).load(categoria.strCategoryThumb).into(binding.imgCategoria)
        binding.txtNameStore.text = categoria.strCategory
        binding.txtDetail.text = categoria.strCategoryDescription
        binding.btnAddFavorite.apply{
            visibility= if(categoria.isFavorite) View.GONE else View.VISIBLE
        }
        binding.btnAddFavorite.setOnClickListener{
            categoria.isFavorite=true
            viewModel.addFavorite(categoria)
        }
    }

}