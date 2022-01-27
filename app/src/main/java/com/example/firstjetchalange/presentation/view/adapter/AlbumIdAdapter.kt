package com.example.firstjetchalange.presentation.view.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.firstjetchalange.data.models.albumId.AlbumIdList
import com.example.firstjetchalange.data.models.albumId.AlbumIdListItem
import com.example.firstjetchalange.databinding.AlbumidItemBinding
import com.example.firstjetchalange.presentation.view.fragments.AlbumIdFragment

class AlbumIdAdapter (
    private val fragment: Fragment
    ):RecyclerView.Adapter<AlbumIdAdapter.ViewHolder>(){

    private var albums : List<AlbumIdListItem> = listOf()

    var arraylist = ArrayList<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:AlbumidItemBinding =
            AlbumidItemBinding.inflate(LayoutInflater.from(fragment.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val albumsList = albums.get(position)
        holder.titleAlbumId.text = albumsList.title

        holder.linearAlbum.setOnClickListener{
            if (fragment is AlbumIdFragment){
                fragment.showPerfectlyUser(
                    albumsList.albumId,
                    albumsList.id,
                    albumsList.url,
                    albumsList.title,
                )
            }
        }

    }

    override fun getItemCount(): Int {
        return albums.size
    }


    fun albumsListItem(list : List<AlbumIdListItem>){
        albums = list
        notifyDataSetChanged()
    }

    class ViewHolder(view:AlbumidItemBinding):RecyclerView.ViewHolder(view.root){
        val titleAlbumId = view.titleAlbumId
        val linearAlbum = view.cardView
    }
}