package com.example.shortvideo.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.AdapterViewBindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shortvideo.R
import com.example.shortvideo.bean.AttentionFrgRecommendBean
import com.example.shortvideo.databinding.ViewRvRecommendBinding

/**
 * @ClassName AttentionFrgRvAdapter
 * @author Silence~
 * @date 2022/7/23
 * @Description “关注”界面中的“推荐关注”列表适配器
 */
class AttentionFrgRvAdapter(private val list : List<AttentionFrgRecommendBean.Data>,
                            private val activity: Activity
)
    : RecyclerView.Adapter<AttentionFrgRvAdapter.InnerRvHolder>() {

    inner class InnerRvHolder(binding: ViewRvRecommendBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerRvHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.view_rv_recommend, parent, false)
        val binding : ViewRvRecommendBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.view_rv_recommend, parent, false)
        return InnerRvHolder(binding)
    }

    override fun onBindViewHolder(holder: InnerRvHolder, position: Int) {
        val binding : ViewRvRecommendBinding? = DataBindingUtil.getBinding(holder.itemView)
        binding?.data = list[position]
    }

    override fun getItemCount() = list.size
}