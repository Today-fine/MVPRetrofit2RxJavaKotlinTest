package com.ye.weather.mvpretrofit2rxjavakotlintest.http

import android.content.Context
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import okhttp3.ResponseBody
import java.io.InputStream

abstract class RxSubcriber<T>(var context: Context):Observer<ResponseBody> {
    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(t: ResponseBody) {
        onSuccess(t.byteStream())
    }



    override fun onError(e: Throwable) {

    }
    abstract fun onSuccess(t: InputStream)

}