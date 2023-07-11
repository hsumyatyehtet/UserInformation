package com.hmyh.userinfo.data.repository

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hmyh.userinfo.data.vos.UserListVO
import com.hmyh.userinfo.network.UserInfoApi
import com.hmyh.userinfo.persistance.daos.UserListDao
import com.hmyh.userinfo.utils.subscribeDBWithCompletable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserInfoRepository @Inject constructor(
    private val userInfoApi: UserInfoApi,
    private val userListDao: UserListDao
) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @SuppressLint("CheckResult")
    suspend fun loadUserList(
        onSuccess: (userListVO: List<UserListVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        var liveData = MutableLiveData<List<UserListVO>>()

        userInfoApi.loadUserList().subscribeOn(
            Schedulers.io()
        )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { userList ->

                    liveData.postValue(userList)

                    onSuccess(userList)
                    userListDao.insertUserList(userList).subscribeDBWithCompletable()
                }
            }, {
                onFailure(it.toString())
            })

    }

    fun getUserList(): LiveData<List<UserListVO>> {
        return userListDao.getUserList()
    }

    fun getUserById(userId: Int) {



        userListDao.getUserByUserId(userId)
    }

}