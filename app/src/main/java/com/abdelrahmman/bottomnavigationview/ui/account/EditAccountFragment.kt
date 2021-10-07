package com.abdelrahmman.bottomnavigationview.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.abdelrahmman.bottomnavigationview.R

class EditAccountFragment : BaseAccountFragment(), View.OnClickListener {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.apply_changes_btn).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.apply_changes_btn -> findNavController().navigate(R.id.action_editAccountFragment_to_editSuccessFragment)
        }
    }

}