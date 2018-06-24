package com.yehiahd.movies.ui.base

import android.os.Bundle
import android.support.annotation.UiThread
import android.support.v7.app.AppCompatActivity
import com.yehiahd.movies.app.MoviesApp

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @UiThread
    protected fun getActivityComponent() =
            (application as MoviesApp).getApplicationComponent()
                    .newActivityComponent()


}
