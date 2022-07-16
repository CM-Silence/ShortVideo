package com.example.shortvideo.base

import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity


/**
 * @ClassName BaseActivity
 * @author Silence~
 * @date 2022/7/16
 */
open class BaseActivity : AppCompatActivity() {

    /**
     * @Description 在Activity被创建时将其添加进ActivityManager类中的列表中
     * @date 2022/7/16 14:05
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT //锁定竖屏
        cancelStatusBar() //透明状态栏
        Log.d("BaseActivity","${javaClass.simpleName} onCreate") //打印当前活动的类名
        AppManager.addActivity(this)
    }

    /**
     * @Description 在Activity被销毁时将其从ActivityManager类中的列表中移除
     * @date 2022/7/16 14:06
     */
    override fun onDestroy() {
        super.onDestroy()
        Log.d("BaseActivity","${javaClass.simpleName} onDestroy") //打印当前活动的类名
        AppManager.removeActivity(this)
    }

    //防止按回退键后直接退出程序
    override fun onBackPressed() {
        moveTaskToBack(true)
    }

    private fun cancelStatusBar() {
        window.requestFeature(Window.FEATURE_NO_TITLE)
        val window = window
        window.clearFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
        )
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarColor = Color.TRANSPARENT
    }
}
