package com.abdelrahmman.bottomnavigationview.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.abdelrahmman.bottomnavigationview.R

class HomeFragment: BaseHomeFragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.go_first_floor_btn).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.go_first_floor_btn -> findNavController().navigate(R.id.action_homeFragment_to_homeFirstFragment)
        }
    }

}