package com.example.shortvideo.model

import com.example.shortvideo.bean.AttentionFrgRecommendBean
import com.example.shortvideo.net.ApiService
import com.example.shortvideo.net.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @ClassName AttentionFragment
 * @author Silence~
 * @date 2022/7/24
 * @Description
 */
class AttentionModel {
    fun getAttentionList() : AttentionFrgRecommendBean?{
        var m : AttentionFrgRecommendBean? = null
        val service : ApiService = RetrofitInstance.instance.create(ApiService::class.java)
        val response : Call<AttentionFrgRecommendBean?>? = service.getAttentionRecommend()
        response?.enqueue(object : Callback<AttentionFrgRecommendBean?> {
            override fun onResponse(
                call: Call<AttentionFrgRecommendBean?>?,
                response: Response<AttentionFrgRecommendBean?>?
            ) {
                m = response?.body()
                val a = 0
            }

            override fun onFailure(call: Call<AttentionFrgRecommendBean?>?, t: Throwable?) {

            }

        })
        return m
    }
}