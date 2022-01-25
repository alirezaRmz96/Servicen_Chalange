package com.example.firstjetchalange.presentation.view.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstjetchalange.R
import com.example.firstjetchalange.data.models.albumId.AlbumIdList
import com.example.firstjetchalange.databinding.FragmentAlbumIdBinding
import com.example.firstjetchalange.presentation.di.Injector
import com.example.firstjetchalange.presentation.view.adapter.AlbumIdAdapter
import com.example.firstjetchalange.presentation.view.viewModel.AlbumIdViewModel
import com.example.firstjetchalange.presentation.view.viewModel.AlbumIdViewModelFactory
import javax.inject.Inject
import kotlin.properties.Delegates


class AlbumIdFragment : Fragment() {

    @Inject
    lateinit var albumIdFactory:AlbumIdViewModelFactory
    private lateinit var albumIdViewModel: AlbumIdViewModel
    private var mBinding:FragmentAlbumIdBinding?=null
    private lateinit var albumIdAdapter: AlbumIdAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as Injector).createAlbumIdSubComponent()
            .inject(this@AlbumIdFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        albumIdViewModel = ViewModelProvider(this@AlbumIdFragment,albumIdFactory)
            .get(AlbumIdViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        mBinding = FragmentAlbumIdBinding.inflate(inflater,container,false)

        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: AlbumIdFragmentArgs by navArgs()
        val userId  = args.userId
        mBinding!!.titleAlbumId.text = requireContext().getString(R.string.albumid_title,userId)
        mBinding!!.albumIdRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
        albumIdAdapter = AlbumIdAdapter(this@AlbumIdFragment)
        mBinding!!.albumIdRecyclerView.adapter = albumIdAdapter

        mBinding!!.albumIdProgressBar.visibility = View.VISIBLE
        albumIdViewModel.getAlbumId().observe(viewLifecycleOwner){
            it->
            it.let {
                if (it != null) {
                    Log.d("TAG", "onViewCreated: " + it[0][1])
                    mBinding!!.albumIdRecyclerView.visibility = View.VISIBLE
                    mBinding!!.albumIdProgressBar.visibility = View.GONE
                    albumIdAdapter.albumsList(userId,it)
                }
                else{
                    mBinding!!.albumIdRecyclerView.visibility = View.GONE
                    mBinding!!.albumIdProgressBar.visibility = View.VISIBLE
                }
            }





        }



    }
//    fun initializeRecyclerView(userID : Int,list: List<AlbumIdList>){
//        mBinding!!.albumIdRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
//        albumIdAdapter = AlbumIdAdapter(this@AlbumIdFragment)
//        mBinding!!.albumIdRecyclerView.adapter = albumIdAdapter
//        albumIdAdapter.albumsList(userID,list)
//    }



}


