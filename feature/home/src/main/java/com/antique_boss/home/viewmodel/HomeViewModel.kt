package com.antique_boss.home.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antique_boss.home.repo.HomeRepository
import com.antique_boss.home.usecase.GetPostUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase
) : ViewModel() {
    fun test() {
        viewModelScope.launch {
            val response = getPostUseCase()
            Log.d("JsonPlaceHolder", response.body().toString())
        }
    }
}