package com.yehiahd.movies.ui.base


import android.support.v4.app.Fragment

abstract class BaseFragment : Fragment() {

    fun getBaseActivity(): BaseActivity = (activity as BaseActivity)

}
