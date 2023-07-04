package com.hmyh.userinfo.ui.screens.userdetailscreen

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

@Preview
@Composable
fun UserDetailScreen(){
    Text(
        text = "User Detail",
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.colorPrimaryText)
        ),
        modifier = Modifier.padding(start = 8.dp)
    )
}