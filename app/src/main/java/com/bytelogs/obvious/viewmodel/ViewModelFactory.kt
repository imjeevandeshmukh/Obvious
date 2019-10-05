package com.bytelogs.obvious.viewmodel

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bytelogs.obvious.repository.MainRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton

class ViewModelFactory @Inject constructor(val mainRepository: MainRepository): ViewModelProvider.Factory{


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return  MainViewModel(mainRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}