package com.bharath.codeJournals.api

import com.bharath.codeJournals.model.AlbumDetailsModel
import com.bharath.codeJournals.model.AlbumsModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Bharath KM on 2/5/21.
 */
class ApiService {
    val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ApiInterface::class.java)

    fun getAlbums(): Single<List<AlbumsModel>> {
        return api.getAlbumDetails()
    }

    fun getAlbumMetadata(albumId: String): Single<List<AlbumDetailsModel>> {
        return api.getAlbumMetaData(albumId)
    }
}