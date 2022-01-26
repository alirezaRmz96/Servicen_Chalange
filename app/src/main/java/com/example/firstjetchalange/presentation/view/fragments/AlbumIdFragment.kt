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
import com.example.firstjetchalange.R
import com.example.firstjetchalange.databinding.FragmentAlbumIdBinding
import com.example.firstjetchalange.presentation.di.Injector
import com.example.firstjetchalange.presentation.view.viewModel.AlbumIdViewModel
import com.example.firstjetchalange.presentation.view.viewModel.AlbumIdViewModelFactory
import javax.inject.Inject


class AlbumIdFragment : Fragment() {

    @Inject
    lateinit var albumIdFactory:AlbumIdViewModelFactory
    private lateinit var albumIdViewModel: AlbumIdViewModel
    private var mBinding:FragmentAlbumIdBinding?=null

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
        val args: AlbumIdFragmentArgs by navArgs()
        val userId  = args.userId
        mBinding = FragmentAlbumIdBinding.inflate(inflater,container,false)
        mBinding!!.albumidTest.text = userId.toString()
        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        albumIdViewModel.getAlbumId().observe(viewLifecycleOwner){
            it->
            if ( it!!.isNotEmpty())
           {
                Log.d("MyAlbumIs", "MyAlbumIs: " + it)
            }
        }

    }


}