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

class AlbumIdAdapter (
    private val fragment: Fragment
    ):RecyclerView.Adapter<AlbumIdAdapter.ViewHolder>(){

    var albums : ArrayList<AlbumIdListItem>? = null

    var arraylist = ArrayList<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:AlbumidItemBinding =
            AlbumidItemBinding.inflate(LayoutInflater.from(fragment.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //val albumsList = albums!!.get(position)
        //holder.titleAlbumId.text = albumsList.title
    }

    override fun getItemCount(): Int {
        return 1
    }

    @SuppressLint("NotifyDataSetChanged")
    fun albumsList(userId : Int,list : List<AlbumIdList>){
        for (i in (userId*10) downTo  (userId*10)-10 step 1){
            Log.d("TAG", "albumsList: " + i)
            if (list[0][i].albumId <= i) {
                Log.d("TAG", "albumsList: " + list[0][i].albumId)

            }
            albums?.add(list[0][i])
        }

        Log.d("TAG", "albumsList: " + albums)
        notifyDataSetChanged()
    }

    class ViewHolder(view:AlbumidItemBinding):RecyclerView.ViewHolder(view.root){
        val titleAlbumId = view.titleAlbumId
    }
}