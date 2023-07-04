package com.hmyh.userinfo.ui.screens.userlistscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hmyh.userinfo.data.vos.UserListVO
import com.hmyh.userinfo.utils.getUserList

typealias OnUserItemClick = (UserListVO) -> Unit

@Composable
fun UserListScreen(
    modifier: Modifier = Modifier,
    onUserItemClick: OnUserItemClick
) {

    var userList = getUserList()

    var text by remember { mutableStateOf("") }

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

@Preview
@Composable
fun UserListScreenPreview() {
    //UserListScreen()
}