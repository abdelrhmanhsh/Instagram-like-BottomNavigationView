package com.abdelrahmman.bottomnavigationview.di.main

import androidx.lifecycle.ViewModel
import com.abdelrahmman.bottomnavigationview.di.ViewModelKey
import com.abdelrahmman.bottomnavigationview.viewmodels.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel


}