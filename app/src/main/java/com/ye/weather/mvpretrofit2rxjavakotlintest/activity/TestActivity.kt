package com.ye.weather.mvpretrofit2rxjavakotlintest.activity

import android.content.Context
import android.util.Log
import com.ye.weather.mvpretrofit2rxjavakotlintest.R
import com.ye.weather.mvpretrofit2rxjavakotlintest.mvp.view.ITextView
import com.ye.weather.mvpretrofit2rxjavakotlintest.base.BaseActivity
import com.ye.weather.mvpretrofit2rxjavakotlintest.mvp.presenter.TestPresenter
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : BaseActivity<TestPresenter>(), ITextView {

    private lateinit var mContext: Context
    private val TAG = javaClass.simpleName
    /**
     * 由Presenter调用
     */
    override fun start() {
        testActivity()
    }

    fun testActivity() {
        Log.d(TAG, "拥有ITestView的引用")
    }

    //调用此方法会内部调用了setContentView
    override fun getLayoutId(): Int {
        return R.layout.activity_test
    }

    /**
     * 初始化中间的持有者
     */
    override fun initPresenter() {
        mContext = this
        mPresenter =
            TestPresenter(
                mContext,
                this
            )
    }

    override fun initView() {
        mPresenter.testPresenter()
        requestBaidu.setOnClickListener {
            Log.e(TAG,"开始调用TextPresenter")
            //1 、需要请求网络获取数据
            mPresenter.requestHome()
        }
    }

    /**
     * 数据请求成功的回调
     */
    override fun responseHome(str: String) {
        Log.e(TAG,"访问成功，Activity回调数据是：${str}")
    }

}
/*
    Activity需要发送网络请求 通过mPresenter：TestPresenter提供的请求方法调用消息
*/