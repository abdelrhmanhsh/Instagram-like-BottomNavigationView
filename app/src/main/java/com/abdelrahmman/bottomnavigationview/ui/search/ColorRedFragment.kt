package com.abdelrahmman.bottomnavigationview.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abdelrahmman.bottomnavigationview.R

class ColorRedFragment : BaseSearchFragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_color_red, container, false)
    }

}