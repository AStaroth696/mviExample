package com.natife.example.mviexample.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.natife.example.mviexample.base.BaseFragment
import com.natife.example.mviexample.base.BaseViewModel

inline fun <reified T : BaseViewModel<*, *>> BaseFragment<T, *>.createViewModel(
    crossinline viewModelInitializer: () -> T
): T {
    return ViewModelProvider(viewModelStore, object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return viewModelInitializer() as T
        }
    }).get(T::class.java)
}