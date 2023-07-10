package com.hmyh.userinfo.ui.screens.userdetailscreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.hmyh.userinfo.R
import com.hmyh.userinfo.data.vos.UserListVO
import com.hmyh.userinfo.ui.theme.UserInfoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailActivity : ComponentActivity() {

    companion object {
        const val EXTRA_USER_ID = "extra user id"

        fun newIntent(context: Context, item: UserListVO): Intent {
            return Intent(context, UserDetailActivity::class.java).apply {
                putExtra(EXTRA_USER_ID, item.id)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var mUserId = intent.getIntExtra(EXTRA_USER_ID, 0)

        setContent {
            UserInfoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.colorLightBlue900)
                ) {
                    UserDetailScreen(modifier = Modifier, mUserId)
                }
            }
        }

    }

}