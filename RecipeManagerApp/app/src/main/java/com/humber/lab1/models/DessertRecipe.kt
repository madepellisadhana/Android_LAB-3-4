package com.humber.lab1.models

class DessertRecipe(
    id:Int,
    title: String,
    ingredients: String,
    instructions: String,
    sweetnessLevel: String
): Recipe (id,title,ingredients,instructions,  "Dessert")
{
    var sweetnessLevel : String = sweetnessLevel
    override fun getDetails(): String{
        return super.getDetails() +"""\n Sweetness Level: $sweetnessLevel""".trimIndent();
    }

}