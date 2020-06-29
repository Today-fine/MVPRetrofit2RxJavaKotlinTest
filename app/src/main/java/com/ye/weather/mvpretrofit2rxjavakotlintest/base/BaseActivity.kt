package com.ye.weather.mvpretrofit2rxjavakotlintest.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ye.weather.mvpretrofit2rxjavakotlintest.mvp.presenter.BasePresenter


abstract class BaseActivity<P : BasePresenter<*>> :AppCompatActivity(){

    protected lateinit var mPresenter :P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        setScreenRotate(true)
        initPresenter()
        initView()
    }

    protected abstract fun getLayoutId(): Int
    protected abstract fun initPresenter()
    protected abstract fun initView()


    /**
     * 设置屏幕为横屏还是为竖屏
     */
    private fun setScreenRotate(screenRotate: Boolean) {
        requestedOrientation = if (screenRotate) {
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT //设置锁定为竖屏
        } else {
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE //锁定为横屏
        }
    }

}
