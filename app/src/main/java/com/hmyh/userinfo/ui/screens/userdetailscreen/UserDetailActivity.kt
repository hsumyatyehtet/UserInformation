package com.hmyh.userinfo.ui.screens.userdetailscreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.hmyh.userinfo.data.vos.UserListVO
import com.hmyh.userinfo.ui.theme.UserInfoTheme

internal const val USER_NAME = "user name"

fun launchUserDetail(context: Context, item: UserListVO) {
    context.startActivity(createDetailActivityContent(context, item))
}

fun createDetailActivityContent(context: Context, item: UserListVO): Intent {
    val intent = Intent(context, UserDetailActivity::class.java)
    intent.putExtra(USER_NAME, item.name)
    return intent
}

class UserDetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UserInfoTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    UserDetailScreen()
                }
            }
        }

    }

}