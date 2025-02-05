package com.humber.lab1.models

open class Recipe(
    var id: Int,
    var title: String,
    var ingredients: String,
    var instructions: String,
    var category: String
) {
    open fun getDetails(): String{
        return """ 
        Title: $title
        Ingredients: $ingredients,
        Instructions: $instructions
        Category: $category
        """.trimIndent();
    }

}