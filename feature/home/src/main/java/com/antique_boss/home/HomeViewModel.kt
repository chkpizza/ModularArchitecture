package com.antique_boss.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antique_boss.preview_crawler.PreviewCrawler
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    fun getPreview(parseUrl: String) {
        viewModelScope.launch {
            val preview = PreviewCrawler().getPreview(parseUrl)
            Log.d("previewTest", preview.toString())
        }
    }
}