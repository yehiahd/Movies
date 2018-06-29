package com.yehiahd.movies.ui.detailscreen

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.yehiahd.movies.R
import com.yehiahd.movies.databinding.ActivityDetailBinding
import com.yehiahd.movies.ui.base.BaseActivity
import com.yehiahd.movies.util.Constant
import javax.inject.Inject


class DetailActivity : BaseActivity() {

    @Inject
    lateinit var detailViewModelProvider: DetailViewModelProvider

    lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        getActivityComponent().inject(this)
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
        binding.movie = intent.extras.getParcelable(Constant.Extra.MOVIE)
        init()
    }

    private fun init() {
        detailViewModel = ViewModelProviders.of(this, detailViewModelProvider).get(DetailViewModel::class.java)
    }
}
