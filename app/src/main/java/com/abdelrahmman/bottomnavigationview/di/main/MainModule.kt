package com.abdelrahmman.bottomnavigationview.di.main

import com.abdelrahmman.bottomnavigationview.data.MainRepository
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @MainScope
    @Provides
    fun provideMainRepository(
    ): MainRepository {
        return MainRepository(
        )
    }

}