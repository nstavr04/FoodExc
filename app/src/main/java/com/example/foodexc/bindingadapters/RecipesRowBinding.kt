package com.example.foodexc.bindingadapters

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import coil.load
import com.example.foodexc.R
import com.example.foodexc.models.Result
import com.example.foodexc.ui.fragments.recipes.RecipesFragmentDirections
import org.jsoup.Jsoup
import java.lang.Exception

class RecipesRowBinding {

    companion object {

        // Whenever we click on a result from out recipes we will store the result information to the
        // avtion variable and we will also change to the detailsActivity fragment
        @BindingAdapter("onRecipeClickListener")
        @JvmStatic
        fun onRecipeClickListener(recipeRowLayout: ConstraintLayout, result: Result){
            recipeRowLayout.setOnClickListener {
                try{
                    val action =
                        RecipesFragmentDirections.actionRecipesFragmentToDetailsActivity(result)
                    recipeRowLayout.findNavController().navigate(action)
                } catch (e: Exception){
                    Log.d("onRecipeClickListener", e.toString())
                }
            }
        }

        // Coil image library to load the image url
        // Added a fade animation of 600ms
        @BindingAdapter("loadImageFromUrl")
        @JvmStatic
        fun loadImageFromUrl(imageView: ImageView, imageUrl: String){
            imageView.load(imageUrl){
                crossfade(600)
                // Display our error placeholder in case that we cannot show an image
                error(R.drawable.ic_error_placeholder)
            }
        }


        // API sends us if a recipe is cheap.
        // We use the function to trigger the color on the costly image and text view of the
        // row layout
        @BindingAdapter("applyCostlyColor")
        @JvmStatic
        fun applyCostlyColor(view: View, cheap: Boolean){
            if(!cheap){
                when(view){
                    is TextView -> {
                        view.setTextColor(
                            ContextCompat.getColor(
                                view.context,
                                R.color.green
                            )
                        )
                    }
                    is ImageView -> {
                        view.setColorFilter(
                            ContextCompat.getColor(
                                view.context,
                                R.color.green
                            )
                        )
                    }
                }
            }
        }

        // Parse our html tags with Jsoup
        @BindingAdapter("parseHtml")
        @JvmStatic
        fun parseHtml(textView: TextView, description: String?){
            if(description != null){
                val desc = Jsoup.parse(description).text()
                textView.text = desc
            }
        }

    }

}