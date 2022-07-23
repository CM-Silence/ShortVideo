package com.example.shortvideo.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * @ClassName RetrofitInstance
 * @author Silence~
 * @date 2022/7/23 21:23
 * @Description
 */
class RetrofitInstance private constructor() {

    init {
        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    companion object {
        private var retrofit: Retrofit? = null
        const val BASE_URL = "http://tools.cretinzp.com/jokes"

        val instance: RetrofitInstance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitInstance()
        }
    }

    //这样调用，可以把retrofit设置为private
    fun <T> create(service: Class<T>): T {
        return retrofit!!.create(service)
    }
}