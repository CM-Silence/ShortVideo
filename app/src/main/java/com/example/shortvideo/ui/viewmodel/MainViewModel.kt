package com.example.shortvideo.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shortvideo.base.BaseFragment
import com.example.shortvideo.base.BaseViewModel
import com.example.shortvideo.bean.AttentionFrgRecommendBean
import com.example.shortvideo.net.ApiService
import com.example.shortvideo.net.RetrofitInstance
import com.example.shortvideo.ui.fragment.*
import com.example.shortvideo.ui.fragment.hpfrg.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @ClassName HomePageViewModel
 * @author Silence~
 * @date 2022/7/17
 * @Description
 */
class MainViewModel : BaseViewModel() {
    val mainFrgList = ArrayList<BaseFragment>() //MainActivity中的fragment列表
    val hpFrgList = ArrayList<BaseFragment>() //HomePageFragment中Vp2中的fragment列表
    private var _dataList = MutableLiveData<List<AttentionFrgRecommendBean.Data>?>()
    var dataList : LiveData<List<AttentionFrgRecommendBean.Data>?>  = _dataList

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

    fun getAttentionList(listener : OnResponseListener){
        val service : ApiService = RetrofitInstance.instance.create(ApiService::class.java)
        val response : Call<AttentionFrgRecommendBean?>? = service.getAttentionRecommend()
        response?.enqueue(object : Callback<AttentionFrgRecommendBean?> {
            override fun onResponse(
                call: Call<AttentionFrgRecommendBean?>?,
                response: Response<AttentionFrgRecommendBean?>?
            ) {
                _dataList.value = response?.body()?.data
                listener.onSuccess()
            }

            override fun onFailure(call: Call<AttentionFrgRecommendBean?>?, t: Throwable?) {
                _dataList.value = ArrayList()
                listener.onDefeat()
            }

        })
    }

    override fun onCleared() {
        super.onCleared()
        mainFrgList.clear()
        hpFrgList.clear()
    }

    interface OnResponseListener{
        fun onSuccess()
        fun onDefeat()
    }

}