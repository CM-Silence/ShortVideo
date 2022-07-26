package com.example.shortvideo.ui.fragment.hpfrg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shortvideo.R
import com.example.shortvideo.base.BaseFragment
import com.example.shortvideo.bean.AttentionFrgRecommendBean
import com.example.shortvideo.databinding.ViewRvRecommendBinding
import com.example.shortvideo.ui.adapter.AttentionFrgRvAdapter
import com.example.shortvideo.ui.viewmodel.MainViewModel

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

    private lateinit var mRvRecommend : RecyclerView
    private lateinit var mRvContent : RecyclerView

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
        initView(view)
        initRv()
    }

    private fun initView(view : View){
        mRvRecommend = view.findViewById(R.id.attentionfrg_rv_recommend)
        mRvContent = view.findViewById(R.id.attentionfrg_rv_content)
    }

    private fun initRv(){
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        mRvRecommend.layoutManager = layoutManager
        viewModel.getAttentionList(object : MainViewModel.OnResponseListener{
            override fun onSuccess(dataList : List<AttentionFrgRecommendBean.Data>?) {
                mRvRecommend.adapter = AttentionFrgRvAdapter(dataList!!,requireActivity())
            }

            override fun onDefeat() {
                TODO("Not yet implemented")
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