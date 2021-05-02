package com.bharath.codetrix.ui.main

import android.content.Context
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bharath.codetrix.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders

/**
 * Created by Bharath KM on 2/5/21.
 */
class AlbumsDisplayAdapter(
    c: Context,
    albums: List<AlbumModel>,
    albumDetails: List<AlbumDetailsModel>,
) : BaseAdapter() {
    private val mContext: Context
    private var mAlbumDetails: List<AlbumDetailsModel>? = null
    private var mAlbums:List<AlbumModel>? = null

    override fun getCount(): Int {
        return mAlbumDetails!!.size
    }

    override fun getItem(position: Int): Any {
        return mAlbumDetails!![position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        val gridView: View?

        gridView = inflate(mContext, R.layout.grid_item, null)

        //tablayout tab text
//        MainActivity.tabs?.getTabAt(position)?.text = mAlbums?.get(position)?.getTitle()

        // title
        val textView = gridView.findViewById<View>(R.id.grid_item_text) as TextView
        textView.text = mAlbumDetails!![position].getTitle()

        //image
        val imageView = gridView.findViewById<View>(R.id.grid_item_image) as ImageView
        val url = GlideUrl(
            mAlbumDetails!![position].getThumbnailUrl()?.trim(), LazyHeaders.Builder()
                .addHeader("User-Agent", "my-user-agent")
                .build()
        )
        Glide.with(mContext)
            .load(url)
            .into(imageView)

        return gridView
    }

    // Constructor
    init {
        mContext = c
        mAlbumDetails = albumDetails
        mAlbums = albums
    }
}