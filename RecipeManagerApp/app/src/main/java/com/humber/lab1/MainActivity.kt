package com.humber.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.humber.lab1.ui.theme.RecipeManagerAppTheme

import com.humber.lab1.models.Recipe
import android.widget.Button
import android.content.Intent

class MainActivity : ComponentActivity() {

    companion object {
        var currentRecipe : Recipe? = null;
    }
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addEditButton: Button = findViewById(R.id.btn_add_edit_recipe);

        val viewButton :Button = findViewById(R.id.btn_view_recipe);

        addEditButton.setOnClickListener{
            val intent = Intent(this,AddEditRecipeActivity::class.java)
            startActivity(intent)
        }

        viewButton.setOnClickListener{
            val intent = Intent(this,ViewRecipeActivity::class.java)
            startActivity(intent)
        }


    }
}

