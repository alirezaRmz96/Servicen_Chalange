package com.example.firstjetchalange.presentation.view.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.firstjetchalange.R
import com.example.firstjetchalange.data.models.userInfo.UserInfoList
import com.example.firstjetchalange.data.models.userInfo.UserInfoListItem
import com.example.firstjetchalange.databinding.UserinfoItemBinding
import com.example.firstjetchalange.presentation.view.fragments.UserInfoFragment
import kotlin.math.log

class UserInfoAdapter(
    private val fragment: Fragment
    ): RecyclerView.Adapter<UserInfoAdapter.ViewHolder>(){

    private var userInfoList:List<UserInfoListItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInfoAdapter.ViewHolder {
        val binding : UserinfoItemBinding =
            UserinfoItemBinding.inflate(LayoutInflater.from(fragment.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserInfoAdapter.ViewHolder, position: Int) {
        val userInfo = userInfoList[position]
        holder.idUser.text = fragment.context?.getString(R.string.id_user,userInfo.id.toString())
        holder.nameUser.text = fragment.context?.getString(R.string.name_user,userInfo.name)
        holder.emailUser.text =fragment.context?.getString(R.string.email_user,userInfo.email)
        holder.phoneUser.text = fragment.context?.getString(R.string.phone_user,userInfo.phone)


        holder.linearUser.setOnClickListener{
            if (fragment is UserInfoFragment){
                fragment.goToAlbumIdFragment(userInfo.id)
            }
        }

    }

    override fun getItemCount(): Int {
        return userInfoList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun userInfoList(list: List<UserInfoList>){
        Log.i("MyTag", "userInfoList: " + list[0].size)
        userInfoList = list[0]
        Log.i("MyTag", "userInfoList: " + userInfoList)
        notifyDataSetChanged()
    }

    class ViewHolder(view:UserinfoItemBinding):RecyclerView.ViewHolder(view.root){
        val idUser = view.idUser
        val nameUser = view.nameUser
        val emailUser = view.emailUser
        val phoneUser = view.phoneUser
        val linearUser = view.cardView
    }
}