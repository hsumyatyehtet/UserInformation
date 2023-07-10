package com.hmyh.userinfo.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hmyh.userinfo.data.repository.UserInfoRepository
import com.hmyh.userinfo.data.vos.UserListVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userInfoRepository: UserInfoRepository
) : ViewModel() {

    /** it is used before local database add.  **/
    // private val userList = MutableStateFlow(emptyList<UserListVO>())
    // val mUserList: StateFlow<List<UserListVO>> get() = userList

    var mUserList: LiveData<List<UserListVO>> = userInfoRepository.getUserList()

    init {
        loadUserList()

    }

    private fun loadUserList() {

        viewModelScope.launch {

            userInfoRepository.loadUserList(
                onSuccess = {
                    /** it is used before local data add.  **/
                    // userList.value = it
                },
                onFailure = {
                    Log.e("error", it)
                }
            )

        }

    }

//    private fun getUserList() {
//        userInfoRepository.getUserList()
//    }

}