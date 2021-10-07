package com.abdelrahmman.bottomnavigationview.util

import android.app.Activity
import android.content.Context
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.abdelrahmman.bottomnavigationview.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavController(
        val context: Context,
        @IdRes val containerId: Int,
        @IdRes val appStartDestinationId: Int,
        val graphChangeListener: OnNavigationGraphChanged?,
        val navGraphProvider: NavGraphProvider
) {
    
    lateinit var activity: Activity
    lateinit var fragmentManager: FragmentManager
    lateinit var navItemChangeListener: OnNavigationItemChanged

    private val navigationBackStack = BackStack.of(appStartDestinationId)

    init {
        if (context is Activity){
            activity = context
            fragmentManager = (activity as FragmentActivity).supportFragmentManager
        }
    }

    fun onNavigationItemSelected(itemId: Int = navigationBackStack.last()): Boolean{

        //replace fragment representing a navigation item
        val fragment = fragmentManager.findFragmentByTag(itemId.toString())
                ?: NavHostFragment.create(navGraphProvider.getNavGraphId(itemId))

        fragmentManager.beginTransaction()
                .setCustomAnimations(
                        R.anim.fade_in,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.fade_out
                )
                .replace(containerId, fragment, itemId.toString())
                .addToBackStack(null)
                .commit()

        // add to backStack
        navigationBackStack.moveLast(itemId)

        //update the nav bar with the new fragment
        navItemChangeListener.onItemChanged(itemId)

        //communicate with the activity
        graphChangeListener?.onGraphChange()

        return true
    }

    fun onBackPressed(){
        val childFragmentManager = fragmentManager.findFragmentById(containerId)!!
                .childFragmentManager
        when {
            childFragmentManager.popBackStackImmediate() -> {

            }

            //fragment backstack is empty so try to go back on the navigation stack
            navigationBackStack.size > 1 ->{

                //remove the last item from backstack
                navigationBackStack.removeLast()

                //update the container with new fragment
                onNavigationItemSelected()

            }

            //if the stack has only 1 and it's not the nav home we should ensure that the app always leave from start destination
            navigationBackStack.last() != appStartDestinationId -> {
                navigationBackStack.removeLast()
                navigationBackStack.add(0, appStartDestinationId)
                onNavigationItemSelected()
            }

            else -> activity.finish()

        }
    }

    private class BackStack: ArrayList<Int>(){

        companion object{

            fun of(vararg elements: Int): BackStack{
                val b = BackStack()
                b.addAll(elements.toTypedArray())
                return b
            }
        }

        fun removeLast() = removeAt(size - 1)

        fun moveLast(item: Int){
            remove(item)
            add(item)
        }

    }

    // for setting the checked icon in the bottom nav
    interface OnNavigationItemChanged {
        fun onItemChanged(itemId: Int)
    }

    fun setOnItemNavigationChanged(listener: (itemId: Int) -> Unit){
        this.navItemChangeListener = object: OnNavigationItemChanged{
            override fun onItemChanged(itemId: Int) {
                listener.invoke(itemId)
            }

        }
    }

    //get id of each graph
    interface NavGraphProvider{
        @NavigationRes
        fun getNavGraphId(itemId: Int): Int
    }

    interface OnNavigationGraphChanged{
        fun onGraphChange()
    }

    interface OnNavigationReselectedListener{
        fun onReselectNavItem(navController: NavController, fragment: Fragment)
    }

}

fun BottomNavigationView.setUpNavigation(
        bottomNavController: BottomNavController,
        onReselectListener: BottomNavController.OnNavigationReselectedListener
){

    setOnItemSelectedListener {
        bottomNavController.onNavigationItemSelected(it.itemId)
    }

    setOnItemReselectedListener {
        bottomNavController
                .fragmentManager
                .findFragmentById(bottomNavController.containerId)!!
                .childFragmentManager
                .fragments[0]?.let { fragment ->
            onReselectListener.onReselectNavItem(
                    bottomNavController.activity.findNavController(bottomNavController.containerId),
                    fragment
            )
        }
    }

    bottomNavController.setOnItemNavigationChanged { itemId ->
        menu.findItem(itemId).isChecked = true
    }

}