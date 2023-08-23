package com.example.themeal.view

import android.content.Intent

import android.os.Bundle

import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher

import androidx.appcompat.app.AppCompatActivity

import com.example.themeal.databinding.ActivityAddCategoriaBinding
import com.example.themeal.model.CategoriaFirebase
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AddCategoriaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddCategoriaBinding
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCategoriaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firestore =  Firebase.firestore



        binding.btnRegisterCategoria.setOnClickListener {
            val strCategory: String = binding.tilCouponTitle.editText?.text.toString()
            val strCategoryDescription: String = binding.tilCouponDetail.editText?.text.toString()

            if (strCategory.isNotEmpty() && strCategoryDescription.isNotEmpty()) {
                val coupon = hashMapOf(
                    "strCategory" to strCategory,
                    "strCategoryDescription" to strCategoryDescription,
                    "strCategoryThumb" to ""
                )
                firestore.collection("categoria")
                    .add(coupon)
                    .addOnSuccessListener {
                        Toast.makeText(
                            this,
                            "Agregado correctamente con id: ${it.id}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "No se agrego el elemento", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }
    private fun getData(){
        firestore.collection("categoria").get()
            .addOnSuccessListener {
                val categorias = mutableListOf<CategoriaFirebase>()
                for(document in it.documents){
                    val categoria = CategoriaFirebase(

                        strCategory=document.data?.get("strCategory").toString(),"",""

                    )
                    categorias.add(categoria)
                }

            }
    }



}
