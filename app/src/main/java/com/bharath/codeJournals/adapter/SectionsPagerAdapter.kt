package com.bharath.codeJournals.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bharath.codeJournals.model.AlbumsModel
import com.bharath.codeJournals.view.PlaceholderFragment

/**
 * Created by Bharath KM on 2/5/21.
 */
class SectionsPagerAdapter(
    private val context: Context,
    fm: FragmentManager,
    private val albumsList: ArrayList<AlbumsModel>
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return PlaceholderFragment.newInstance(position + 1, albumsList = albumsList)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return albumsList[position].getTitle()
    }

    override fun getCount(): Int {
        return albumsList.size
    }
}