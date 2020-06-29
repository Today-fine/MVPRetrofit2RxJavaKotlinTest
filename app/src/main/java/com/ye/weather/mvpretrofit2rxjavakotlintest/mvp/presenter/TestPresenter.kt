package com.ye.weather.mvpretrofit2rxjavakotlintest.mvp.presenter

import android.content.Context
import android.util.Log
import com.ye.weather.mvpretrofit2rxjavakotlintest.http.RetrofitServiceManager
import com.ye.weather.mvpretrofit2rxjavakotlintest.http.RxJavaHelper
import com.ye.weather.mvpretrofit2rxjavakotlintest.mvp.view.ITextView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import okhttp3.ResponseBody


class TestPresenter(context:Context,view:ITextView) :BasePresenter<ITextView>(context,view) {

    private val TAG = javaClass.simpleName

    fun testPresenter() {
        Log.e(javaClass.simpleName,"拥有TestPresenter引用")
        mView.start()
    }

    private val apiService = RetrofitServiceManager.createService()

    fun requestHome(){
        Log.e(TAG,"TestPresenter被调用")
        //获取数据之后走 mView提供的方法 //RxJava中subscribe中可以传入MyObserver匿名类作为参数
        apiService.requestHome("")
            .compose(RxJavaHelper.observeOnMainThread())
            .subscribe(object : Consumer<ResponseBody>{
                override fun accept(body : ResponseBody) {
                    Log.e(TAG,"TestPresenter访问网络成功")
                    val str = body.string().toString()
                    mView.responseHome(str)
                }

            })

    }

    inner class myObserver : Observer<ResponseBody> {
        override fun onComplete() {
            Log.e(TAG,"onComplete")
        }

        override fun onSubscribe(d: Disposable) {
            Log.e(TAG,"onSubscribe")
        }

        override fun onNext(t: ResponseBody) {
            //数据访问成功的回调
            Log.e(TAG,"onNext")
        }

        override fun onError(e: Throwable) {
            Log.e(TAG,"onError : ${e}")
        }
    }

}


