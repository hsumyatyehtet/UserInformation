package com.hmyh.userinfo.data.repository

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.hmyh.userinfo.data.vos.UserListVO
import com.hmyh.userinfo.network.UserInfoApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserInfoRepository @Inject constructor(
    private val userInfoApi: UserInfoApi
) {

    @SuppressLint("CheckResult")
    fun loadUserList(
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
                    // mDatabase.userListDao().insertUserList(userList).subscribeDBWithCompletable()
                }
            }, {
                onFailure(it.toString())
            })

    }

}