package com.example.nabarro.meusfilmes.ViewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.nabarro.meusfilmes.`interface`.LoginResultCalBack

class LoginViewModelFactory (private val listener:LoginResultCalBack):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(listener) as T
    }
}