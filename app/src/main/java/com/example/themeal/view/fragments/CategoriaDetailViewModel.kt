package com.example.themeal.view.fragments


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.themeal.db.CategorieDataBase
import com.example.themeal.model.Categoria
import com.example.themeal.repository.CategorieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriaDetailViewModel (application: Application): AndroidViewModel(application) {
    private val repository: CategorieRepository

    init {
        val db = CategorieDataBase.getDatabase(application)
        repository= CategorieRepository(db.categorieDao())
    }
    fun addFavorite(categoria: Categoria){
        viewModelScope.launch (Dispatchers.IO){
            repository.addFavorite(categoria)
        }
    }
}