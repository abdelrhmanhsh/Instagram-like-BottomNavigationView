package com.abdelrahmman.bottomnavigationview.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.abdelrahmman.bottomnavigationview.R
import com.abdelrahmman.bottomnavigationview.ui.account.EditAccountFragment
import com.abdelrahmman.bottomnavigationview.ui.account.EditSuccessFragment
import com.abdelrahmman.bottomnavigationview.ui.account.ViewAccountFragment
import com.abdelrahmman.bottomnavigationview.ui.home.HomeFirstFragment
import com.abdelrahmman.bottomnavigationview.ui.home.HomeSecondFragment
import com.abdelrahmman.bottomnavigationview.ui.search.ColorBlueFragment
import com.abdelrahmman.bottomnavigationview.ui.search.ColorRedFragment
import com.abdelrahmman.bottomnavigationview.util.BottomNavController
import com.abdelrahmman.bottomnavigationview.util.setUpNavigation
import com.abdelrahmman.bottomnavigationview.viewmodels.ViewModelProviderFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(),
        BottomNavController.NavGraphProvider,
        BottomNavController.OnNavigationGraphChanged,
        BottomNavController.OnNavigationReselectedListener
{

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var toolbar: Toolbar

    private val bottomNavController by lazy(LazyThreadSafetyMode.NONE){
        BottomNavController(
                this,
                R.id.main_nav_host_fragment,
                R.id.nav_home,
                this,
                this
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.tool_bar)
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setUpNavigation(bottomNavController, this)
        if (savedInstanceState == null){
            bottomNavController.onNavigationItemSelected()
        }

        setupActionBar()


    }

    private fun setupActionBar(){
        setSupportActionBar(toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            android.R.id.home -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() = bottomNavController.onBackPressed()

    override fun getNavGraphId(itemId: Int) = when(itemId) {

        R.id.nav_home -> {
            R.navigation.nav_home
        }

        R.id.nav_search -> {
            R.navigation.nav_search
        }

        R.id.nav_account -> {
            R.navigation.nav_account
        }

        else -> {
            R.navigation.nav_home
        }

    }

    override fun onGraphChange() {
        // Cancel Active Jobs!
    }

    override fun onReselectNavItem(navController: NavController, fragment: Fragment) = when(fragment) {

        is HomeFirstFragment -> {
            navController.navigate(R.id.action_homeFirstFragment_to_homeFragment)
        }

        is HomeSecondFragment -> {
            navController.navigate(R.id.action_homeSecondFragment_to_homeFragment)
        }

        is ColorBlueFragment -> {
            navController.navigate(R.id.action_colorBlueFragment_to_searchFragment)
        }

        is ColorRedFragment -> {
            navController.navigate(R.id.action_colorRedFragment_to_searchFragment)
        }

        is ViewAccountFragment -> {
            navController.navigate(R.id.action_viewAccountFragment_to_accountFragment)
        }

        is EditAccountFragment -> {
            navController.navigate(R.id.action_editAccountFragment_to_accountFragment)
        }

        is EditSuccessFragment -> {
            navController.navigate(R.id.action_editSuccessFragment_to_accountFragment)
        }

        else -> {
            // do nothing
        }

    }

}