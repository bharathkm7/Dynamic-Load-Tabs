package com.bharath.codeJournals.api

import com.bharath.codeJournals.model.AlbumDetailsModel
import com.bharath.codeJournals.model.AlbumsModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Bharath KM on 2/5/21.
 */
interface ApiInterface {
    @GET("/albums")
    fun getAlbumDetails(): Single<List<AlbumsModel>>

    @GET("/photos")
    fun getAlbumMetaData(@Query("albumId") name: String): Single<List<AlbumDetailsModel>>
}