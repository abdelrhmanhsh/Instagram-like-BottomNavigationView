package com.abdelrahmman.bottomnavigationview.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abdelrahmman.bottomnavigationview.R

class HomeSecondFragment: BaseHomeFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_second, container, false)
    }

}