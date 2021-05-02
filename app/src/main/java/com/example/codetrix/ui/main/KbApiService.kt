package com.example.codetrix.ui.main

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Bharath KM on 2/5/21.
 */
class KbApiService {
    val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(KbApiInterface::class.java)

    fun getAlbums(): Single<List<AlbumModel>> {
        return api.getAlbumDetails()
    }

    fun getAlbumMetadata(albumId: String): Single<List<AlbumDetailsModel>> {
        return api.getAlbumMetaData(albumId)
    }
}