package com.yehiahd.movies.ui.mainscreen

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.androidnetworking.error.ANError
import com.yehiahd.movies.R
import com.yehiahd.movies.ui.base.BaseActivity
import com.yehiahd.movies.util.Constant
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var mMainViewModel: MainViewModel

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    @Inject
    lateinit var gridLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        getActivityComponent().inject(mainActivity = this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        recyclerMovies.layoutManager = gridLayoutManager
        getMoviesByType(Constant.Api.POPULAR)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return menu?.let {
            menuInflater.inflate(R.menu.menu_main, menu)
            true
        } ?: false
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        compositeDisposable.clear()
        return when (item?.itemId) {
            R.id.top_rated -> {
                getMoviesByType(Constant.Api.TOP_RATED)
                true
            }

            R.id.popular -> {
                getMoviesByType(Constant.Api.POPULAR)
                true
            }

            else -> false
        }
    }

    private fun getMoviesByType(type: String) {
        progressBar.visibility = View.VISIBLE
        mMainViewModel.getMoviesByType(type)
                .doOnSubscribe { compositeDisposable.add(it) }
                .subscribe({
                    recyclerMovies.adapter = MoviesAdapter(this, it)
                    progressBar.visibility = View.GONE
                }, {
                    Toast.makeText(this, (it as ANError).errorDetail, Toast.LENGTH_SHORT).show()
                })
    }

    override fun onPause() {
        super.onPause()
        compositeDisposable.clear()
    }

}
