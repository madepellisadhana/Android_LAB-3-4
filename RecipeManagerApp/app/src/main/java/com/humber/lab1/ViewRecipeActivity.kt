package com.humber.lab1

import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ViewRecipeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_view_recipe)


        val recipeDetails : TextView = findViewById(R.id.text_recipe_details)
        val deleteButton: Button = findViewById(R.id.btn_delete_recipe)

        MainActivity.currentRecipe?.let {
            recipeDetails.text = it.getDetails()
        }
        deleteButton.setOnClickListener{
            MainActivity.currentRecipe = null
            finish()
        }
    }
}