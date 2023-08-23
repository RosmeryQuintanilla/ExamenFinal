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
import com.example.themeal.R
import com.example.themeal.databinding.FragmentCategoriaListBinding
import com.example.themeal.view.adapter.RVCategoriaListAdapter



class CategoriaListFragment : Fragment() {

    private lateinit var binding: FragmentCategoriaListBinding
    private lateinit var viewModel: CategoriaListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(CategoriaListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCategoriaListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVCategoriaListAdapter(listOf()){ categoria->
            val couponDetailDirection =CategoriaListFragmentDirections.actionCategoriaListFragmentToCategoriaDetailFragment(categoria)
            findNavController().navigate(couponDetailDirection)

        }
        binding.rvCouponList.adapter = adapter
        binding.rvCouponList.layoutManager = GridLayoutManager(requireContext(),2,
            RecyclerView.VERTICAL,false)
        viewModel.categoriaList.observe(requireActivity()) {
            adapter.categoria = it
            adapter.notifyDataSetChanged()
        }
        viewModel.getCategoriasFromService()
    }

}