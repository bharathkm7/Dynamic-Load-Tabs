package com.bharath.codeJournals.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.bharath.codeJournals.R
import com.bharath.codeJournals.adapter.SectionsPagerAdapter
import com.bharath.codeJournals.model.AlbumsModel
import com.bharath.codeJournals.viewModel.MainActivityViewModel
import com.google.android.material.tabs.TabLayout

/**
 * Created by Bharath KM on 2/5/21.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var albums: List<AlbumsModel>
    private var selectedTab: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabs: TabLayout = findViewById(R.id.tabs)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        mainActivityViewModel.getAlbums()

        mainActivityViewModel.dataModelObject.observe(this, {
            albums = it
            if (albums.isNotEmpty()) {
                selectedTab = if (tabs.selectedTabPosition == -1) 0.also {
                    selectedTab = it
                } else tabs.selectedTabPosition

                val sectionsPagerAdapter = SectionsPagerAdapter(
                    this, supportFragmentManager,
                    albums as ArrayList<AlbumsModel>
                )
                val viewPager: ViewPager = findViewById(R.id.view_pager)
                viewPager.adapter = sectionsPagerAdapter

                tabs.setupWithViewPager(viewPager)
            }
        })
    }
}