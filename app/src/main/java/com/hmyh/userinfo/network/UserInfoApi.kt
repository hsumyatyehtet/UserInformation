package com.hmyh.userinfo.network

import com.hmyh.userinfo.data.vos.UserListVO
import com.hmyh.userinfo.utils.GET_ALL_USER_LIST
import io.reactivex.Observable
import retrofit2.http.GET

interface UserInfoApi {

    @GET(GET_ALL_USER_LIST)
    fun loadUserList(): Observable<List<UserListVO>>


}