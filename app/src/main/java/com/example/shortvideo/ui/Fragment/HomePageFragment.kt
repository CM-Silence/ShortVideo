package com.example.shortvideo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.LifecycleRegistry
import androidx.viewpager2.widget.ViewPager2
import com.example.shortvideo.R
import com.example.shortvideo.base.BaseFragment
import com.example.shortvideo.ui.adapter.HomePageFragmentVp2Adapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomePageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomePageFragment : BaseFragment("首页") {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    private lateinit var mToolBar : Toolbar
    private lateinit var mTabLayout : TabLayout
    private lateinit var mIbtnSearch : ImageButton
    private lateinit var mVp2Show : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initComponent(view)
        initVp2()
        initEvent()
    }

    private fun initData(){

    }

    private fun initComponent(v : View){
        mToolBar = v.findViewById(R.id.hpFrg_toolbar)
        mTabLayout = v.findViewById(R.id.hpFrg_tabLayout)
        mIbtnSearch = v.findViewById(R.id.hpFrg_ibtn_search)
        mVp2Show = v.findViewById(R.id.hpFrg_vp2)
    }

    private fun initVp2(){
        val mainVp2Adapter = HomePageFragmentVp2Adapter(this.parentFragmentManager,viewModel.hpFrgList,
            LifecycleRegistry(this)
        )
        mVp2Show.adapter = mainVp2Adapter
        mVp2Show.offscreenPageLimit = 2 //设置缓存数

        TabLayoutMediator(mTabLayout, mVp2Show
        ) { tab, position -> //在这里给Tab设置Text
            tab.text = viewModel.hpFrgList[position].title
        }.attach()
    }

    private fun initEvent(){

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomePageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomePageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}