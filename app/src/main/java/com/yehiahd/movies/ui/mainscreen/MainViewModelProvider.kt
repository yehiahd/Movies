package com.yehiahd.movies.ui.mainscreen

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.yehiahd.movies.datamodel.DataManager
import javax.inject.Inject

class MainViewModelProvider @Inject constructor(private val dataManager: DataManager) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(DataManager::class.java).newInstance(dataManager)
    }
}