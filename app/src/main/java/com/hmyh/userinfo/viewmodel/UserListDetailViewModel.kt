package com.hmyh.userinfo.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserListDetailViewModel @Inject constructor(
    //private val userInfoRepository: UserInfoRepository
) : ViewModel() {


    fun getUserById(userId: Int) {
       // userInfoRepository.getUserById(userId)
    }

}