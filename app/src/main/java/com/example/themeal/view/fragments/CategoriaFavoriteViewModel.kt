package com.example.themeal.view.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.themeal.db.CategorieDataBase
import com.example.themeal.model.Categoria
import com.example.themeal.repository.CategorieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriaFavoriteViewModel (application: Application): AndroidViewModel(application) {
    private val repository: CategorieRepository
    private val _favorites: MutableLiveData<List<Categoria>> = MutableLiveData()

    val favorites: LiveData<List<Categoria>> = _favorites

    init {
        val db = CategorieDataBase.getDatabase(application)
        repository = CategorieRepository(db.categorieDao())
    }

    fun getFavorites(){
        viewModelScope.launch(Dispatchers.IO){
            val data = repository.getFavorites()
            _favorites.postValue(data)
        }
    }
}