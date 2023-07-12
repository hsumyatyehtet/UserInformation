package com.hmyh.userinfo.ui.screens.userdetailscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.twotone.Email
import androidx.compose.material.icons.twotone.LocationOn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hmyh.userinfo.R
import com.hmyh.userinfo.data.vos.AddressVO
import com.hmyh.userinfo.data.vos.UserListVO
import com.hmyh.userinfo.ui.theme.BackgroundUserDetail
import com.hmyh.userinfo.viewmodel.UserListDetailViewModel

@Composable
fun UserDetailScreen(
    modifier: Modifier = Modifier,
    userId: Int
) {

    val mUserListDetailViewModel = viewModel(modelClass = UserListDetailViewModel::class.java)
    val mUser = mUserListDetailViewModel.getUserById(userId).observeAsState()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorLightBlue900))
//            .verticalScroll(rememberScrollState())
    ) {

        Column {

            Image(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "",
                colorFilter = ColorFilter.tint(
                    color = colorResource(id = R.color.white)
                ),
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp)
            )

            mUser.value?.let {
                UserNameSection(it)
                Spacer(modifier = Modifier.height(40.dp))
                UserInformationSection(it)
            }

        }
    }
}


@Composable
fun UserNameSection(user: UserListVO) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = user.name.toString(),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white)
            ),
        )

        Text(
            text = "@ ${user.userName}",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.white)
            ),
            modifier = Modifier.padding(top = 4.dp)
        )

    }
}


@Composable
fun UserInformationSection(user: UserListVO) {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White,
        shape = BackgroundUserDetail
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            UserInformationDetailItem(
                title = "Email",
                dataText = "${user.email}",
                icon = Icons.TwoTone.Email
            )

            UserInformationDetailItem(
                title = "Address",
                dataText = "${user.address?.suite}," +
                        " ${user.address?.street}, ${user.address?.city}",
                icon = Icons.TwoTone.LocationOn
            )

            UserInformationDetailItem(
                title = "Phone",
                dataText = "${user.phone}",
                icon = ImageVector.vectorResource(id = R.drawable.twotone_phone_android)
            )

            UserInformationDetailItem(
                title = "Website",
                dataText = "${user.website}",
                icon = ImageVector.vectorResource(id = R.drawable.twotone_web)
            )

        }
    }

}


@Preview
@Composable
fun UserDetailScreenPreview(
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorLightBlue900))
//            .verticalScroll(rememberScrollState())
    ) {

        Column {

            Image(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "",
                colorFilter = ColorFilter.tint(
                    color = colorResource(id = R.color.white)
                ),
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp)
            )

            UserNameSection(
                user = UserListVO(
                    1, "Hsu Myat Ye Htet", "hsumyatyehtet",
                    "hsumyatyehtet@gmail.com", AddressVO(
                        "Ahlone Road", "", "Yangon", ""
                    ), "09999",
                    "github.com/hsumyatyehtet"
                )
            )

            Spacer(modifier = Modifier.height(40.dp))

            UserInformationSection(
                user = UserListVO(
                    1, "Hsu Myat Ye Htet", "hsumyatyehtet",
                    "hsumyatyehtet@gmail.com", AddressVO(
                        "Ahlone Road", "", "Yangon", ""
                    ), "09999",
                    "github.com/hsumyatyehtet"
                )
            )

        }
    }
}



