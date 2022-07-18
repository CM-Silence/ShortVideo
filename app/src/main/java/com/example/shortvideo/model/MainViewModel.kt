package com.example.shortvideo.model

import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModel
import com.example.shortvideo.base.BaseFragment
import com.example.shortvideo.ui.adapter.HomePageFragmentVp2Adapter
import com.example.shortvideo.ui.fragment.*
import com.example.shortvideo.ui.fragment.hpfrg.*

/**
 * @ClassName HomePageViewModel
 * @author Silence~
 * @date 2022/7/17
 * @Description
 */
class MainViewModel : ViewModel() {
    val mainFrgList = ArrayList<BaseFragment>() //MainActivity中的fragment列表
    val hpFrgList = ArrayList<BaseFragment>() //HomePageFragment中Vp2中的fragment列表

    init{
        mainFrgList.apply {
            add(HomePageFragment.newInstance("",""))
            add(ShortVideoFragment.newInstance("",""))
            add(PublishFragment.newInstance("",""))
            add(MessageFragment.newInstance("",""))
            add(MineFragment.newInstance("",""))
        }

        hpFrgList.apply {
            add(AttentionFragment.newInstance("",""))
            add(RecommendFragment.newInstance("",""))
            add(NewsFragment.newInstance("",""))
            add(TextFragment.newInstance("",""))
            add(ImageFragment.newInstance("",""))
        }
    }

    override fun onCleared() {
        super.onCleared()
        mainFrgList.clear()
        hpFrgList.clear()
    }

}