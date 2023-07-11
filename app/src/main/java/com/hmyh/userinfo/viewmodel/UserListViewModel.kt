package com.hmyh.userinfo.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hmyh.userinfo.data.repository.UserRepository
import com.hmyh.userinfo.data.vos.UserListVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userRepository: UserRepository

) : ViewModel() {

    var mUserList: LiveData<List<UserListVO>> = userRepository.getUserList()

    init {

        viewModelScope.launch {
            var userList = async { fetUserList() }

            userList.await()
        }

    }

    private suspend fun fetUserList() {
        userRepository.loadUserList(
            onSuccess = {

            },
            onFailure = {

            }
        )
    }

}