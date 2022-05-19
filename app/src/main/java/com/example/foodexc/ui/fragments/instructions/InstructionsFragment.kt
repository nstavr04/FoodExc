package com.example.foodexc.ui.fragments.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.foodexc.R
import com.example.foodexc.databinding.FragmentIngredientsBinding
import com.example.foodexc.databinding.FragmentInstructionsBinding
import com.example.foodexc.util.Constants.Companion.RECIPE_RESULT_KEY
import com.example.foodexc.models.Result

class InstructionsFragment : Fragment() {

    private var _binding: FragmentInstructionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentInstructionsBinding.inflate(inflater, container, false)


        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPE_RESULT_KEY)

        binding.instructionsWebView.webViewClient = object : WebViewClient() {}
        // Need to check this
        val websiteUrl: String? = myBundle!!.sourceUrl
        if (websiteUrl != null) {
            binding.instructionsWebView.loadUrl(websiteUrl)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}