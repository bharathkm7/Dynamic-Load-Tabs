package com.example.codetrix.ui.main

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

/**
 * Created by Bharath KM on 2/5/21.
 */
class AlbumDetailsModel() : Parcelable {
    @SerializedName("albumId")
    @Expose
    private var albumId: Int? = null

    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("title")
    @Expose
    private var title: String? = null

    @SerializedName("url")
    @Expose
    private var url: String? = null

    @SerializedName("thumbnailUrl")
    @Expose
    private var thumbnailUrl: String? = null

    constructor(parcel: Parcel) : this() {
        albumId = parcel.readValue(Int::class.java.classLoader) as? Int
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        title = parcel.readString()
        url = parcel.readString()
        thumbnailUrl = parcel.readString()
    }

    fun getAlbumId(): Int? {
        return albumId
    }

    fun setAlbumId(albumId: Int?) {
        this.albumId = albumId
    }

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String?) {
        this.url = url
    }

    fun getThumbnailUrl(): String? {
        return thumbnailUrl
    }

    fun setThumbnailUrl(thumbnailUrl: String?) {
        this.thumbnailUrl = thumbnailUrl
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(albumId)
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeString(url)
        parcel.writeString(thumbnailUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AlbumDetailsModel> {
        override fun createFromParcel(parcel: Parcel): AlbumDetailsModel {
            return AlbumDetailsModel(parcel)
        }

        override fun newArray(size: Int): Array<AlbumDetailsModel?> {
            return arrayOfNulls(size)
        }
    }
}