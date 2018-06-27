package com.yehiahd.movies.ui.detailscreen

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.yehiahd.movies.R
import com.yehiahd.movies.databinding.ActivityDetailScreenBinding
import com.yehiahd.movies.ui.base.BaseActivity
import com.yehiahd.movies.util.Constant


class DetailScreen : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDetailScreenBinding>(this, R.layout.activity_detail_screen)
        binding.movie = intent.extras.getParcelable(Constant.Extra.MOVIE)
    }

}
