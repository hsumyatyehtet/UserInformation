package com.hmyh.userinfo.ui.screens.userlistscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hmyh.userinfo.data.vos.UserListVO

@Composable
fun UserList(
    userList: List<UserListVO>,
    modifier: Modifier = Modifier,
    onUserItemClick: OnUserItemClick,
    listState: LazyListState= rememberLazyListState()
) {
    LazyColumn(
        modifier = modifier,
        state = listState
    ) {
        items(
            items = userList
        ) { user ->
            UserListItem(
                userListVO = user,
                onUserItemClick
            )
        }
    }
}