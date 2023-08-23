package com.example.themeal.model
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "categoria")
@Parcelize
data class Categoria(
    @SerializedName("idCategory")
    @PrimaryKey
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String,
    var isFavorite:Boolean=false
): Parcelable


fun getData():List<Categoria> =
    listOf(
        Categoria("1","Carne","","es un nombre culinario para la comida de res"),
        Categoria("2","Pollo","","es un tipo de ave domestica, una subespecie del falo "),
        Categoria("3","Dessent","","es un plato que consiste en alimentos dulces"),
        Categoria("4","Cordero","","es un nombre culinario para la comida de res"),
        Categoria("5","Pasta","","es un alimento basico de la cosina tradicional italiana"),
        Categoria("6","Pork","","es el nombreculinario de la carne de cerdo")

    )

