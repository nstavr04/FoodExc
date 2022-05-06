package com.example.foodexc.ui.fragments.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.foodexc.R
import com.example.foodexc.util.Constants.Companion.RECIPE_RESULT_KEY
import kotlinx.android.synthetic.main.fragment_instructions.view.*
import com.example.foodexc.models.Result

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_instructions, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPE_RESULT_KEY)

        view.instructions_webView.webViewClient = object : WebViewClient() {}
        // Need to check this
        val websiteUrl: String? = myBundle!!.sourceUrl
        if (websiteUrl != null) {
            view.instructions_webView.loadUrl(websiteUrl)
        }

        return view
    }

}