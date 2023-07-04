package com.hmyh.userinfo.ui.screens.userlistscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.twotone.Email
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hmyh.userinfo.R
import com.hmyh.userinfo.data.vos.UserListVO

@Composable
fun UserListItem(
    userListVO: UserListVO,
    onUserItemClick: OnUserItemClick,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = Modifier
            .clickable { onUserItemClick(userListVO) }
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white),
        ),
    ) {

        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start
        ) {

            UserRowName(
                name = userListVO.name,
                userName = userListVO.userName
            )

            UserRowMail(
                email = userListVO.email
            )
        }


    }

}

@Composable
fun UserRowName(
    name: String? = null,
    userName: String? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = "",
            modifier = Modifier.size(26.dp)
        )

        Text(
            text = name.toString() + " ( @$userName )",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.colorPrimaryText)
            ),
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun UserRowMail(
    email: String? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            imageVector = Icons.TwoTone.Email,
            contentDescription = "",
            modifier = Modifier.size(26.dp)
        )

        Text(
            text = email.toString(),
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.colorSecondaryText)
            ),
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
fun UserItemPreview() {
//    UserListItem(
//        UserListVO(1, "Hsu Myat Ye Htet", "hsumyatyehtet", "hsumyatyehtet@gmail.com")
//    )
}

@Preview
@Composable
fun UserRowNamePreview() {
    UserRowName()
}

@Preview
@Composable
fun UserRowMailPreview() {
    UserRowMail()
}