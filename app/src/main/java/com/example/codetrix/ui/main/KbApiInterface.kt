package com.example.codetrix.ui.main

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Bharath KM on 2/5/21.
 */
interface KbApiInterface {
    @GET("/albums")
    fun getAlbumDetails(): Single<List<AlbumModel>>

    @GET("/photos")
    fun getAlbumMetaData(@Query("albumId") name: String): Single<List<AlbumDetailsModel>>
}