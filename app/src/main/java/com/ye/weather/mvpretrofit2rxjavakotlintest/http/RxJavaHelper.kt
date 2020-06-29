package com.ye.weather.mvpretrofit2rxjavakotlintest.http

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object RxJavaHelper {
    fun <T> observeOnMainThread():ObservableTransformer<T,T>{
        return ObservableTransformer<T, T> {    upstream ->
            upstream.subscribeOn(Schedulers.io()) //网络请求在后台线程
                .observeOn(AndroidSchedulers.mainThread())//最后的回调在主线程
        }
    }

}