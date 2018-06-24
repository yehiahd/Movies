package com.yehiahd.movies.ui.mainscreen

import android.os.Bundle
import android.util.Log
import com.androidnetworking.error.ANError
import com.yehiahd.movies.R
import com.yehiahd.movies.ui.base.BaseActivity
import com.yehiahd.movies.util.Constant
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var mMainViewModel: MainViewModel

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        getActivityComponent().inject(mainActivity = this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        mMainViewModel.getMoviesByType(Constant.Api.POPULAR)
                .doOnSubscribe { compositeDisposable.add(it) }
                .subscribe({ movies ->
                    Log.d("Movies", movies.size.toString())
                }, {
                    Log.d("Error", (it as ANError).errorDetail)
                }, {
                    Log.d("Completed", "Good")
                })
    }

    override fun onPause() {
        super.onPause()
        compositeDisposable.clear()
    }

}
