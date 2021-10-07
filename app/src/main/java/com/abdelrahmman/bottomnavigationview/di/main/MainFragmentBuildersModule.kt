package com.abdelrahmman.bottomnavigationview.di.main

import com.abdelrahmman.bottomnavigationview.ui.account.AccountFragment
import com.abdelrahmman.bottomnavigationview.ui.account.EditAccountFragment
import com.abdelrahmman.bottomnavigationview.ui.account.EditSuccessFragment
import com.abdelrahmman.bottomnavigationview.ui.account.ViewAccountFragment
import com.abdelrahmman.bottomnavigationview.ui.home.HomeFirstFragment
import com.abdelrahmman.bottomnavigationview.ui.home.HomeFragment
import com.abdelrahmman.bottomnavigationview.ui.home.HomeSecondFragment
import com.abdelrahmman.bottomnavigationview.ui.search.ColorBlueFragment
import com.abdelrahmman.bottomnavigationview.ui.search.ColorRedFragment
import com.abdelrahmman.bottomnavigationview.ui.search.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector()
    abstract fun contributeAccountFragment(): AccountFragment

    @ContributesAndroidInjector()
    abstract fun contributeEditAccountFragment(): EditAccountFragment

    @ContributesAndroidInjector()
    abstract fun contributeEditSuccessFragment(): EditSuccessFragment

    @ContributesAndroidInjector()
    abstract fun contributeViewAccountFragment(): ViewAccountFragment


    @ContributesAndroidInjector()
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector()
    abstract fun contributeHomeFirstFragment(): HomeFirstFragment

    @ContributesAndroidInjector()
    abstract fun contributeHomeSecondFragment(): HomeSecondFragment


    @ContributesAndroidInjector()
    abstract fun contributeSearchFragment(): SearchFragment

    @ContributesAndroidInjector()
    abstract fun contributeColorBlueFragment(): ColorBlueFragment

    @ContributesAndroidInjector()
    abstract fun contributeColorRedFragment(): ColorRedFragment

}