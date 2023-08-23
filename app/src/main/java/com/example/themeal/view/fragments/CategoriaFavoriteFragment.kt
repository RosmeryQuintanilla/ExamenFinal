package com.example.themeal.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themeal.databinding.FragmentCategoriaFavoriteFrangmentBinding
import com.example.themeal.view.adapter.RVCategoriaListAdapter


class CategoriaFavoriteFragment : Fragment() {

    private lateinit var binding: FragmentCategoriaFavoriteFrangmentBinding
    private lateinit var viewModel: CategoriaFavoriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(CategoriaFavoriteViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCategoriaFavoriteFrangmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVCategoriaListAdapter(listOf()){ categoria->
            val categoriaDetailDirection =CategoriaFavoriteFragmentDirections.actionCategoriaFavoriteFragmentToCategoriaDetailFragment(categoria)
            findNavController().navigate(categoriaDetailDirection)

        }
        binding.rvCategoriaList.adapter = adapter
        binding.rvCategoriaList.layoutManager = GridLayoutManager(
            requireContext(), 2,
            RecyclerView.VERTICAL, false
        )
        viewModel.favorites.observe(requireActivity()) {
            adapter.categoria = it
            adapter.notifyDataSetChanged()
        }
        viewModel.getFavorites()
    }
}