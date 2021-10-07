package com.abdelrahmman.bottomnavigationview.viewmodels

import androidx.lifecycle.ViewModel
import com.abdelrahmman.bottomnavigationview.data.MainRepository
import javax.inject.Inject

class MainViewModel
@Inject constructor(
    private val repository: MainRepository,
): ViewModel() {

    // Add functions here

}