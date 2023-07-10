package com.hmyh.userinfo.ui.screens.userdetailscreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.hmyh.userinfo.R
import com.hmyh.userinfo.data.vos.UserListVO
import com.hmyh.userinfo.ui.theme.UserInfoTheme

class UserDetailActivity : ComponentActivity() {

    companion object{
        const val USER_NAME = "user name"

        fun newIntent(context: Context,item: UserListVO): Intent{
            return Intent(context,UserDetailActivity::class.java).apply {
                putExtra(USER_NAME,item.name)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UserInfoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.colorLightBlue900)
                ) {
                    UserDetailScreen()
                }
            }
        }

    }

}