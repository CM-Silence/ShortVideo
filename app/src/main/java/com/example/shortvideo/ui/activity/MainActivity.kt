package com.example.shortvideo.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.shortvideo.R
import com.example.shortvideo.base.BaseActivity
import com.example.shortvideo.base.BaseFragment
import com.example.shortvideo.ui.viewmodel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : BaseActivity() {
    private lateinit var mFrameLayoutShow : FrameLayout
    private lateinit var bottomNavigation : BottomNavigationView
    private lateinit var mainViewModel : MainViewModel

    private var mFragmentManager: FragmentManager? = null

    private var currentFragment: BaseFragment? = null //用于记录当前显示的界面

    companion object{
        fun startActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initComponent()
    }

    private fun initData(){
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private fun initComponent(){
        mFrameLayoutShow = findViewById(R.id.main_framelayout_show)
        bottomNavigation = findViewById(R.id.main_bottomNavigationView)

        changeFragment(mainViewModel.mainFrgList[0]) //先显示“首页”界面

        bottomNavigation.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.homePageFragment -> {
                        changeFragment(mainViewModel.mainFrgList[0])
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.shortVideoFragment -> {
                        changeFragment(mainViewModel.mainFrgList[1])
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.publishFragment -> {
                        changeFragment(mainViewModel.mainFrgList[2])
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.messageFragment -> {
                        changeFragment(mainViewModel.mainFrgList[3])
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.mineFragment -> {
                        changeFragment(mainViewModel.mainFrgList[4])
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            })

    }

    /**
     * @Description 切换fragment的方法
     * @Param fragment 需要切换的碎片
     * @date 2022/7/17 17:46
     */
    private fun changeFragment(fragment : BaseFragment){
        if(fragment != currentFragment) {
            if (mFragmentManager == null) {
                mFragmentManager = this.supportFragmentManager
            }
            val transaction = mFragmentManager!!.beginTransaction()
            if (fragment.isAdded) {
                transaction.show(fragment)
            } else {
                transaction.add(R.id.main_framelayout_show, fragment)
            }
            if (currentFragment != null) {
                transaction.hide(currentFragment!!)
            }
            currentFragment = fragment
            transaction.commit()
        }
    }

}