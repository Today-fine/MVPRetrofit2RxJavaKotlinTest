package com.ye.weather.mvpretrofit2rxjavakotlintest.mvp.view

interface ITextView : IBaseView {
    fun start()
    fun responseHome(str: String)
}