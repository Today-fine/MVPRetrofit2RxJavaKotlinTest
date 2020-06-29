package com.ye.weather.mvpretrofit2rxjavakotlintest.mvp.presenter

import android.content.Context
import com.ye.weather.mvpretrofit2rxjavakotlintest.mvp.view.IBaseView


/**
 * 构造方法让Presenter层持有View的引用
 */
abstract class BasePresenter<V : IBaseView>(context:Context,view: V) {
    /**
     * Presenter持有View
     */
    protected var mView = view

    /**
     * 上下文
     */
    protected var mContext = context
}

/*
    BasePresenter需要持有一个View所以构造方法中必须给一个View的实例
        泛型指定成IBaseView的子类
 */