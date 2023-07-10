package com.hmyh.userinfo.ui.screens.userlistscreen

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.hmyh.userinfo.R
import com.hmyh.userinfo.data.vos.UserListVO
import com.hmyh.userinfo.ui.screens.userdetailscreen.UserDetailActivity
import com.hmyh.userinfo.ui.theme.UserInfoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UserInfoTheme {
                //  A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.colorLightBlue900)
                ) {

                }
                UserListScreen(onUserItemClick = {
                    launchUserDetail(this, it)
                })
            }
        }

    }

    private fun launchUserDetail(context: Context, item: UserListVO) {
        startActivity(UserDetailActivity.newIntent(context, item))
    }

}
