package com.abdelrahmman.bottomnavigationview.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.abdelrahmman.bottomnavigationview.R

class AccountFragment : BaseAccountFragment(), View.OnClickListener {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.edit_account_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.view_account_btn).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.edit_account_btn -> findNavController().navigate(R.id.action_accountFragment_to_editAccountFragment)
            R.id.view_account_btn -> findNavController().navigate(R.id.action_accountFragment_to_viewAccountFragment)
        }
    }

}