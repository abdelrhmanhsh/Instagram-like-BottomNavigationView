package com.abdelrahmman.bottomnavigationview.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abdelrahmman.bottomnavigationview.R

class ViewAccountFragment : BaseAccountFragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_account, container, false)
    }

}