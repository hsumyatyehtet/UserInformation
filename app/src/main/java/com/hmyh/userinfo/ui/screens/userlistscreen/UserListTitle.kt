package com.hmyh.userinfo.ui.screens.userlistscreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hmyh.userinfo.R

@Composable
fun UserListTitle(
    title: String,
    modifier: Modifier = Modifier
){
    Text(
        text = title,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.white)
        ),
        modifier = Modifier.padding(start = 16.dp, top = 16.dp)
    )
}

@Preview
@Composable
fun UserListTitlePreview(){
    UserListTitle(title = "User List")
}