package com.example.shortvideo.base

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.shortvideo.model.MainViewModel

/**
 * @ClassName BaseFragment
 * @author Silence~
 * @date 2022/7/16
 * @Description
 */
open class BaseFragment(var title : String = "") : Fragment() {
    protected val viewModel: MainViewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("BaseFragment","${javaClass.simpleName} onCreate") //打印当前fragment的类名
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("BaseFragment","${javaClass.simpleName} onDestroy") //打印当前fragment的类名
    }

    override fun onResume() {
        super.onResume()
        Log.d("BaseFragment","${javaClass.simpleName} onResume") //打印当前fragment的类名

    }

    override fun onPause() {
        super.onPause()
        Log.d("BaseFragment","${javaClass.simpleName} onPause") //打印当前fragment的类名

    }
}