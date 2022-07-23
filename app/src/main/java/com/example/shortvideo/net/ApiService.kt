package com.example.shortvideo.net

import com.example.shortvideo.bean.AttentionFrgRecommendBean
import retrofit2.Call
import retrofit2.http.Headers
import retrofit2.http.POST


/**
 * @ClassName ApiService
 * @author Silence~
 * @date 2022/7/23
 * @Description 网络请求接口
 */
interface ApiService {

    //获取“关注”中的推荐列表数据
    @Headers("project_token: B06FEB2F5C194146AE4CC0D0E0743372")
    @POST("/home/attention/recommend")
    suspend fun getAttentionRecommend(): Call<AttentionFrgRecommendBean?>?
}