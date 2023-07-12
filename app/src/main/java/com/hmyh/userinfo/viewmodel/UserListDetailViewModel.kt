package com.hmyh.userinfo.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hmyh.userinfo.data.repository.UserRepository
import com.hmyh.userinfo.data.vos.UserListVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListDetailViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun getUserById(userId: Int): LiveData<UserListVO> {

        return userRepository.getUserById(userId)

    }


}