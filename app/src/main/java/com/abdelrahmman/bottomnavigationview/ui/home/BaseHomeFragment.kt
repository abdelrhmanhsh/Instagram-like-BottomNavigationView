package com.abdelrahmman.bottomnavigationview.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.abdelrahmman.bottomnavigationview.R
import com.abdelrahmman.bottomnavigationview.viewmodels.MainViewModel
import com.abdelrahmman.bottomnavigationview.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseHomeFragment : DaggerFragment(){

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var viewModel: MainViewModel

    fun setupActionBarWithNavController(fragmentId: Int, activity: AppCompatActivity){
        val appBarConfiguration = AppBarConfiguration(setOf(fragmentId))
        NavigationUI.setupActionBarWithNavController(
                activity,
                findNavController(),
                appBarConfiguration
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = activity?.run {
            ViewModelProvider(this, providerFactory).get(MainViewModel::class.java)
        }?: throw Exception("Invalid Activity")

        setupActionBarWithNavController(R.id.homeFragment, activity as AppCompatActivity)

    }

}