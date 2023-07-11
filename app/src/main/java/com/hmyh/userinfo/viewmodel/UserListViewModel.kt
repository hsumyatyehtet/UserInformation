package com.hmyh.userinfo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hmyh.userinfo.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userRepository: UserRepository

) : ViewModel() {

    init {

        viewModelScope.launch {
            async {
                fetUserList()
            }
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