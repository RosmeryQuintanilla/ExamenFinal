package com.example.themeal.view.fragments


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themeal.model.Categoria
import com.example.themeal.model.getData
import com.example.themeal.repository.CategorieRepository
import com.example.themeal.response.ApiResponse

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriaListViewModel : ViewModel() {
    val repository = CategorieRepository()
    val categoriaList: MutableLiveData<List<Categoria>> = MutableLiveData<List<Categoria>>()

    fun getCategoriaList(){
        val data = getData()
        categoriaList.value = data
    }

    fun getCategoriasFromService(){
        viewModelScope.launch (Dispatchers.IO){
            val response = repository.getCategories()
            when(response){
                is ApiResponse.Error -> {
                    //colocar error
                }
                is ApiResponse.Success ->{
                    categoriaList.postValue(response.data.categories)
                }
            }
        }
    }
    
}