package com.durante.joseph.block5.p1.quiz.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.durante.joseph.block5.p1.quiz.R
import com.durante.joseph.block5.p1.quiz.databinding.FragmentHomeBinding
import com.durante.joseph.block5.p1.quiz.pojo.Meal
import com.durante.joseph.block5.p1.quiz.pojo.MealList
import com.durante.joseph.block5.p1.quiz.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        RetrofitInstance.api.getRandomMeal().enqueue(object : Callback<MealList>{
            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                if(response.body() !=null){
                    val randomMeal:Meal = response.body()!!.meals[0]
                   Glide.with(this@HomeFragment)
                       .load(randomMeal.strMealThumb)
                       .into(binding.imgRandomMeal)
                }else
                    return
            }

            override fun onFailure(call: Call<MealList>, t: Throwable) {
                Log.d("HomeFragment",t.message.toString())
            }
        })




    }


}