package com.example.shortvideo.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.shortvideo.base.BaseFragment

/**
 * @ClassName HomePageFragmentVp2Adapter
 * @author Silence~
 * @date 2022/7/17
 * @Description
 */
class HomePageFragmentVp2Adapter (frgManager: FragmentManager,
                                  private val frgList: MutableList<BaseFragment>,
                                  lifecycle: Lifecycle) :
    FragmentStateAdapter(frgManager, lifecycle){

        /**
         * @Description 用于给ViewPage2添加Fragment的方法
         * @Param fragment 需要传入的Fragment
         * @date 2022/7/17 11:03
         */
        fun addFragment(fragment : BaseFragment){
            frgList.add(fragment)
        }

        override fun getItemCount(): Int {
            return frgList.size
        }

        override fun createFragment(position : Int) : Fragment {
            return frgList[position]
        }

    }