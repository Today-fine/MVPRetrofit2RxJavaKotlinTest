package com.ye.weather.mvpretrofit2rxjavakotlintest.http

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Streaming

interface ApiService {
    companion object{
        const val BASE_URL:String = "http://172.16.30.138/"
    }

    @Streaming
    @GET("{path}")
    fun requestHome(@Path("path") path:String):Observable<ResponseBody>
}