package com.hmyh.userinfo.network

import com.hmyh.userinfo.data.vos.UserListVO
import io.reactivex.Observable
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val api: UserInfoApi) {

    fun fetchUserInformation(): Observable<List<UserListVO>> =
        api.loadUserList()

}