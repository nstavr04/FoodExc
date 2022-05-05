package com.example.foodexc.ui.fragments.recipes.bottomsheet

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import com.example.foodexc.R
import com.example.foodexc.util.Constants.Companion.DEFAULT_CUISINE_TYPE
import com.example.foodexc.util.Constants.Companion.DEFAULT_MEAL_TYPE
import com.example.foodexc.viewmodels.RecipesViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.recipes_bottom_sheet.view.*
import java.util.*

class RecipesBottomSheet : BottomSheetDialogFragment() {

    private lateinit var recipesViewModel: RecipesViewModel
    private var mealTypeChip = DEFAULT_MEAL_TYPE
    private var mealTypeChipId = 0
    private var cuisineTypeChip = DEFAULT_CUISINE_TYPE
    private var cuisineTypeChipId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipesViewModel = ViewModelProvider(requireActivity()).get(RecipesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mView = inflater.inflate(R.layout.recipes_bottom_sheet, container, false)

        recipesViewModel.readMealAndCuisineType.asLiveData().observe(viewLifecycleOwner, { value ->
            mealTypeChip = value.selectedMealType
            cuisineTypeChip = value.selectedCuisineType
            updateChip(value.selectedMealTypeId, mView.mealType_chipGroup)
            updateChip(value.selectedCuisineTypeId, mView.cuisineType_chipGroup)
        })

        // Whenever we selected a chip from out filter we will store their text and ids
        mView.mealType_chipGroup.setOnCheckedChangeListener { group, selectedChipId ->
            val chip = group.findViewById<Chip>(selectedChipId)
            val selectedMealType = chip.text.toString().toLowerCase(Locale.ROOT)
            mealTypeChip = selectedMealType
            mealTypeChipId = selectedChipId
        }

        mView.cuisineType_chipGroup.setOnCheckedChangeListener { group, selectedChipId ->
            val chip = group.findViewById<Chip>(selectedChipId)
            val selectedCuisineType = chip.text.toString().toLowerCase(Locale.ROOT)
            cuisineTypeChip = selectedCuisineType
            cuisineTypeChipId = selectedChipId
        }

        mView.apply_btn.setOnClickListener {
            recipesViewModel.saveMealAndCuisineType(
                mealTypeChip,
                mealTypeChipId,
                cuisineTypeChip,
                cuisineTypeChipId
            )

            val action =
                RecipesBottomSheetDirections.actionRecipesBottomSheetToRecipesFragment(true)
            findNavController().navigate(action)

        }

        return mView
    }

    private fun updateChip(chipId: Int, chipGroup: ChipGroup){
        // If we have made some selections before
        if(chipId != 0) {
            try {
                chipGroup.findViewById<Chip>(chipId).isChecked = true
            } catch (e: Exception){
                Log.d("RecipesBottomSheet", e.message.toString())
            }
        }
    }

}