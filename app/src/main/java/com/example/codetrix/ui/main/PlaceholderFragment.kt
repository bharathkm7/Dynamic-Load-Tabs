package com.example.codetrix.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.codetrix.R

/**
 * Created by Bharath KM on 2/5/21.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private lateinit var gridView: GridView
    private lateinit var albumsList: List<AlbumModel>
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
        albumsList = arguments?.getParcelableArrayList<AlbumModel>(ALBUMS_LIST)!!
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        gridView = root.findViewById(R.id.grid_view)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivityViewModel.getAlbumDetails(arguments?.getInt(ARG_SECTION_NUMBER).toString())
        mainActivityViewModel.dataModelObject2.observe(this, Observer {
            gridView.adapter = AlbumsDisplayAdapter(activity!!,albumsList,it)
        })
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
        private const val ALBUMS_LIST = "albums_list"

        @JvmStatic
        fun newInstance(sectionNumber: Int,albumsList: ArrayList<AlbumModel>): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                    putParcelableArrayList(ALBUMS_LIST, albumsList)
                }
            }
        }
    }
}