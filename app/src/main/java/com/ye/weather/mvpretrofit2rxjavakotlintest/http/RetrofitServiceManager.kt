package com.ye.weather.mvpretrofit2rxjavakotlintest.http

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServiceManager {
    private var mRetrofit:Retrofit = Retrofit.Builder().baseUrl(ApiService.BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun createService(): ApiService {
        return mRetrofit.create(ApiService::class.java)
    }


}