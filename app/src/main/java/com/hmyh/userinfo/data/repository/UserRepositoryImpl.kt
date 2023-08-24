package com.hmyh.userinfo.data.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hmyh.userinfo.data.vos.UserListVO
import com.hmyh.userinfo.network.UserRemoteDataSource
import com.hmyh.userinfo.persistance.UserListDatabase
import com.hmyh.userinfo.persistance.daos.UserListDao
import com.hmyh.userinfo.utils.subscribeDBWithCompletable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor(
    private val userListDatabase: UserListDatabase,
    private val userRemoteDataSource: UserRemoteDataSource
) : BaseRepository(), UserRepository {

    var mUserList: MutableLiveData<List<UserListVO>> = MutableLiveData()

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
                    userListDatabase.userListDao().insertUserList(mUserList).subscribeDBWithCompletable()
                }
            }, {
                onFailure(it.toString())
            })


    }

    override fun getUserList(): LiveData<List<UserListVO>> {
        return userListDatabase.userListDao().getUserList()
    }

    override fun getUserById(userId: Int): LiveData<UserListVO> {
        return userListDatabase.userListDao().getUserByUserId(userId)
    }

}