package com.humber.lab1

import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import android.widget.Button
import android.widget.ArrayAdapter
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.humber.lab1.models.DessertRecipe
import com.humber.lab1.models.MainCourseRecipe

class AddEditRecipeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_edit_recipe)

        val titleField: EditText = findViewById(R.id.input_title)
        val ingredientsField: EditText = findViewById(R.id.input_ingredients)
        val instructionsField: EditText = findViewById(R.id.input_instructions)
        val categorySpinner: Spinner = findViewById(R.id.spinner_category)
        val sweetnessField: EditText = findViewById(R.id.input_sweetness)
        val prepTimeField: EditText = findViewById(R.id.input_prep_time)
        val saveButton: Button = findViewById(R.id.btn_save)

        val categories = listOf("Dessert" , "Main Course")
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorySpinner.adapter=adapter

        MainActivity.currentRecipe?.let { recipe ->
            titleField.setText(recipe.title)
            ingredientsField.setText(recipe.ingredients)
            instructionsField.setText(recipe.instructions)

            when(recipe){
                is DessertRecipe -> {
                    categorySpinner.setSelection(categories.indexOf("Dessert"))
                    sweetnessField.setText(recipe.sweetnessLevel)
                    //prepTimeField.isEnabled = false

                }
                is MainCourseRecipe ->{
                    categorySpinner.setSelection(categories.indexOf("Main Course"))
                    prepTimeField.setText(recipe.preparationTime.toString())
                    //sweetnessField.isEnabled = false
                }
            }
        }

        saveButton.setOnClickListener{
            val title = titleField.text.toString()
            val ingredients = ingredientsField.text.toString()
            val instructions = instructionsField.text.toString()
            val category = categorySpinner.selectedItem.toString()

            MainActivity.currentRecipe = when (category) {
                "Dessert" -> DessertRecipe(
                    id =1 ,
                    title = title,
                    ingredients = ingredients,
                    instructions = instructions,
                    sweetnessLevel = sweetnessField.text.toString()
                )
                "Main Course" -> MainCourseRecipe(
                    id = 1,
                    title = title,
                    ingredients = ingredients,
                    instructions= instructions,
                    preparationTime = prepTimeField.text.toString().toInt()
                )
                else -> null
            }
            finish()
        }

    }
}