package com.hmyh.userinfo.data.repository

import androidx.lifecycle.LiveData
import com.hmyh.userinfo.data.vos.UserListVO

interface UserRepository {

    suspend fun loadUserList(
        onSuccess: (userListVO: List<UserListVO>)->Unit,
        onFailure: (String)->Unit
    )

    fun getUserList(): LiveData<List<UserListVO>>

}