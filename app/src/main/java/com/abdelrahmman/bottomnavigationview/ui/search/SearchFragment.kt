package com.abdelrahmman.bottomnavigationview.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.abdelrahmman.bottomnavigationview.R

class SearchFragment : BaseSearchFragment(), View.OnClickListener {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.search_color_blue).setOnClickListener(this)
        view.findViewById<View>(R.id.search_color_red).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.search_color_blue -> findNavController().navigate(R.id.action_searchFragment_to_colorBlueFragment)
            R.id.search_color_red -> findNavController().navigate(R.id.action_searchFragment_to_colorRedFragment)
        }
    }

}