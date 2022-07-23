package com.example.shortvideo.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shortvideo.net.*

open class BaseViewModel: ViewModel() {
    //内部使用可变的Mutable
    private val _loadStatus = MutableLiveData<LoadState>()

    //对外开放的是final
    open val loadStatus: LiveData<LoadState> = _loadStatus

}