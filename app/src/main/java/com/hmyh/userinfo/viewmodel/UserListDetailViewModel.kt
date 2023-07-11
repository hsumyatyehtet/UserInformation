package com.hmyh.userinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hmyh.userinfo.data.repository.UserInfoRepository
import com.hmyh.userinfo.data.vos.UserListVO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserListDetailViewModel @Inject constructor(
    private val userInfoRepository: UserInfoRepository
) : ViewModel() {


    fun getUserById(userId: Int) {
        userInfoRepository.getUserById(userId)
    }

}