package com.abdelrahmman.bottomnavigationview.di

import com.abdelrahmman.bottomnavigationview.di.main.MainFragmentBuildersModule
import com.abdelrahmman.bottomnavigationview.di.main.MainModule
import com.abdelrahmman.bottomnavigationview.di.main.MainScope
import com.abdelrahmman.bottomnavigationview.di.main.MainViewModelModule
import com.abdelrahmman.bottomnavigationview.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @MainScope
    @ContributesAndroidInjector(
        modules = [MainModule::class, MainFragmentBuildersModule::class, MainViewModelModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity

}