package com.example.foodexc.bindingadapters

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.foodexc.R
import org.w3c.dom.Text

class RecipesRowBinding {

    companion object {

        // Used so we can call setNumberOfLikes on the xml layout so we can convert the likes result
        // from an INT that the API sends us to a String
        @BindingAdapter("setNumberOfLikes")
        // Make it static so we can access it elsewhere
        @JvmStatic
        fun setNumberOfLikes(textView: TextView, likes: Int){
            textView.text = likes.toString()
        }

        @BindingAdapter("setNumberOfMinutes")
        @JvmStatic
        fun setNumberOfMinutes(textView: TextView, minutes: Int){
            textView.text = minutes.toString()
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

    }

}