package com.example.firstjetchalange.presentation.view.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.firstjetchalange.R
import com.example.firstjetchalange.databinding.FragmentPhotoIdBinding





class PhotoIdFragment : Fragment() {

    private var mBinding: FragmentPhotoIdBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentPhotoIdBinding.inflate(inflater,container,false)
        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: PhotoIdFragmentArgs by navArgs()
        mBinding!!.albumID.text = resources.getString(R.string.albumid_title, args.albumId.toString())
        mBinding!!.PhotoID.text =  resources.getString(R.string.photoId,args.photoId.toString())
//        Glide.with(requireActivity())
//            .load(R.drawable.account_box)
//            .listener(object : RequestListener<Drawable>{
//                override fun onLoadFailed(
//                    e: GlideException?,
//                    model: Any?,
//                    target: Target<Drawable>?,
//                    isFirstResource: Boolean
//                ): Boolean {
//
////                    mBinding!!.photoUrl.setImageResource(R.drawable.account_box)
//                    Log.e("TAG", "Error loading image", e)
//                    return false
//                }
//                override fun onResourceReady(
//                    resource: Drawable?,
//                    model: Any?,
//                    target: Target<Drawable>?,
//                    dataSource: DataSource?,
//                    isFirstResource: Boolean
//                ): Boolean {
//                    return true
//                }
//            }).into(mBinding!!.photoUrl)

        mBinding!!.photoUrl.setImageResource(R.drawable.account_box)
        mBinding!!.titleAlbum.text = args.title
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}