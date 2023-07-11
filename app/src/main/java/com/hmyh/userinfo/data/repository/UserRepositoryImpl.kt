package com.hmyh.userinfo.data.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import com.hmyh.userinfo.data.vos.UserListVO
import com.hmyh.userinfo.network.UserRemoteDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) : BaseRepository(), UserRepository {

    @SuppressLint("CheckResult")
    override suspend fun loadUserList(
        onSuccess: (userListVO: List<UserListVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {

        userRemoteDataSource.fetchUserInformation()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ userList ->
                userList?.let {mUserList->
                    onSuccess(mUserList)
                    Log.d("mUserList",mUserList.toString())
                }
            }, {
                onFailure(it.toString())
                Log.d("error",it.toString())
            })

    }

}