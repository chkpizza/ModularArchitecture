package com.antique_boss.modulararchitecutre

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antique_boss.util.ConnectivityMonitor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AppViewModel: ViewModel() {
    private val _isOnline = MutableLiveData<Boolean>()
    val isOnline: LiveData<Boolean> get() = _isOnline

    fun makeConnectivityMonitor(context: Context) {
        viewModelScope.launch {
            ConnectivityMonitor(context).isOnline.collect {
                _isOnline.value = it
            }
        }
    }
}