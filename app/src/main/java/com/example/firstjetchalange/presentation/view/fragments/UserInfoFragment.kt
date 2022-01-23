package com.example.firstjetchalange.presentation.view.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.firstjetchalange.R
import com.example.firstjetchalange.databinding.FragmentUserIfnoBinding
import com.example.firstjetchalange.presentation.di.Injector
import com.example.firstjetchalange.presentation.view.viewModel.UserInfoViewModel
import com.example.firstjetchalange.presentation.view.viewModel.UserInfoViewModelFactory
import javax.inject.Inject


class UserInfoFragment : Fragment() {

    @Inject
    lateinit var factory: UserInfoViewModelFactory
    private lateinit var userInfoViewModel: UserInfoViewModel
    private lateinit var mBinding: FragmentUserIfnoBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as Injector).createUseInfoSubComponent()
            .inject(this@UserInfoFragment)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userInfoViewModel = ViewModelProvider(this@UserInfoFragment,factory)
            .get(UserInfoViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentUserIfnoBinding.inflate(inflater,container,false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userInfoViewModel.getUserInfo().observe(viewLifecycleOwner){
            Log.d("TAG", "onViewCreated: " + it)
        }
    }


}