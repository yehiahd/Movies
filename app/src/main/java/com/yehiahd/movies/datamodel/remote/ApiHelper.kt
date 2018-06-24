package com.yehiahd.movies.datamodel.remote

import com.rx2androidnetworking.Rx2AndroidNetworking
import com.yehiahd.movies.model.MoviesResponse
import com.yehiahd.movies.util.Constant
import io.reactivex.Observable

class ApiHelper : IApiHelper {

    override fun getMoviesByType(type: String): Observable<MoviesResponse> {
        return Rx2AndroidNetworking.get(Constant.Api.BASE_URL + type)
                .addQueryParameter(Constant.Api.API_KEY_KEY, Constant.Api.API_KEY_VALUE)
                .build()
                .getObjectObservable(MoviesResponse::class.java)
    }
}