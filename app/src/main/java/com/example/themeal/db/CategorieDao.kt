package com.example.themeal.db


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.themeal.model.Categoria

@Dao
interface CategorieDao {
    @Query("SELECT * FROM categoria")
    fun getFavorites(): List<Categoria>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavorite(categoria:Categoria)
}