package com.hmyh.userinfo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.hmyh.userinfo.data.repository.UserInfoRepository
import com.hmyh.userinfo.data.vos.UserListVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userInfoRepository: UserInfoRepository
) : ViewModel() {

    private val userList = MutableStateFlow(emptyList<UserListVO>())

    val mUserList: StateFlow<List<UserListVO>> get() = userList

    init {
        getUserList()
    }

    private fun getUserList() {
        userInfoRepository.loadUserList(
            onSuccess = {
                userList.value = it
            },
            onFailure = {
                Log.e("error", it)
            }
        )

    }

}