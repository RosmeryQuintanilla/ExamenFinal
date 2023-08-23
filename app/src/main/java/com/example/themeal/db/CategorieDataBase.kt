package com.example.themeal.db


import com.example.themeal.model.Categoria
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Categoria::class], version =1)
abstract  class CategorieDataBase : RoomDatabase() {
    abstract fun categorieDao(): CategorieDao

    companion object {
        @Volatile
        private var instance: CategorieDataBase? = null
        fun getDatabase(context: Context): CategorieDataBase {
            if (instance == null) {
                synchronized(this) {
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }

        private fun buildDatabase(context: Context): CategorieDataBase? {
            return Room.databaseBuilder(
                context.applicationContext,
                CategorieDataBase::class.java,
                "categoria_database"
            ).build()

        }
    }
    }