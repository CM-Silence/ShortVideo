package com.example.shortvideo.ui.fragment.hpfrg

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.shortvideo.R
import com.example.shortvideo.base.BaseFragment
import com.example.shortvideo.bean.AttentionFrgRecommendBean
import com.example.shortvideo.databinding.ViewRvRecommendBinding
import com.example.shortvideo.ui.adapter.AttentionFrgRvAdapter
import com.example.shortvideo.ui.viewmodel.MainViewModel
import com.example.shortvideo.util.ToastUtil

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AttentionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AttentionFragment : BaseFragment("关注") {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mSwipeRefreshLayout : SwipeRefreshLayout
    private lateinit var mRvRecommend : RecyclerView
    private lateinit var mRvContent : RecyclerView

    private lateinit var rvAdapter : AttentionFrgRvAdapter

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
        return inflater.inflate(R.layout.fragment_attention, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent(view)
        initEvent()
        initRv()
    }

    private fun initComponent(view : View){
        mSwipeRefreshLayout = view.findViewById(R.id.attentionfrg_swipeRefreshLayout)
        mRvRecommend = view.findViewById(R.id.attentionfrg_rv_recommend)
        mRvContent = view.findViewById(R.id.attentionfrg_rv_content)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initEvent(){
        mSwipeRefreshLayout.setOnRefreshListener {
            mSwipeRefreshLayout.isRefreshing = true
            viewModel.getAttentionList(object : MainViewModel.OnResponseListener{
                override fun onSuccess() {
                    ToastUtil.show("刷新成功!")
                    mSwipeRefreshLayout.isRefreshing = false
                }

                override fun onDefeat() {
                    ToastUtil.show("刷新失败！请检查您的网络！")
                    mSwipeRefreshLayout.isRefreshing = false
                }
            })

            val liveData = viewModel.dataList
            liveData.observe(viewLifecycleOwner
            ) {
                rvAdapter.dataList = viewModel.dataList.value!!
                rvAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun initRv(){
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        mRvRecommend.layoutManager = layoutManager
        viewModel.getAttentionList(object : MainViewModel.OnResponseListener{
            override fun onSuccess() {
                rvAdapter = AttentionFrgRvAdapter(viewModel.dataList.value!!)
                mRvRecommend.adapter = rvAdapter
            }

            override fun onDefeat() {
                rvAdapter = AttentionFrgRvAdapter(viewModel.dataList.value!!)
                ToastUtil.show("网络异常,加载失败！")
            }

        })
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AttentionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AttentionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}