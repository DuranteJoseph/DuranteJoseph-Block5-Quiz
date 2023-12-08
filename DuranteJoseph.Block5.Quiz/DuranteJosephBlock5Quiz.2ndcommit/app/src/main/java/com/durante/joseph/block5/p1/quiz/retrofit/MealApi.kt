package com.durante.joseph.block5.p1.quiz.retrofit

import com.durante.joseph.block5.p1.quiz.pojo.MealList
import retrofit2.Call
import retrofit2.http.GET

interface MealApi {

    @GET("random.php")
    fun getRandomMeal():Call<MealList>

}