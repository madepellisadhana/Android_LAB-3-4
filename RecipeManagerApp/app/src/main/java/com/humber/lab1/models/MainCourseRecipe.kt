package com.humber.lab1.models

class MainCourseRecipe (


    id: Int,
    title: String,
    ingredients: String,
    instructions: String,
    preparationTime: Int
    ): Recipe(id,title,ingredients,instructions,"Main Course"){
        var preparationTime: Int = preparationTime;
    override fun getDetails(): String{
        return super.getDetails() + """\n Preparation Time: $preparationTime minutes""".trimIndent();
    }

    }
