package com.hmyh.userinfo.ui.screens.userlistscreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hmyh.userinfo.data.vos.UserListVO
import com.hmyh.userinfo.utils.getUserList
import com.hmyh.userinfo.viewmodel.UserListViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

typealias OnUserItemClick = (UserListVO) -> Unit

@Composable
fun UserListScreen(
    modifier: Modifier = Modifier,
    onUserItemClick: OnUserItemClick,
) {

    val userListVIewModel = viewModel(modelClass = UserListViewModel::class.java)

    val userList: List<UserListVO> by userListVIewModel.mUserList.observeAsState(initial = listOf())

    val text by remember { mutableStateOf("") }

    val listState = rememberLazyListState()

    Column(
        modifier = modifier
    ) {

        UserListTitle(title = "User List")

        Spacer(modifier = Modifier.height(8.dp))

        SearchBar(
            value = text,
            onValueChange = {

            },
        )

        UserList(
            userList = userList,
            onUserItemClick = onUserItemClick,
            listState = listState
        )
    }

}
