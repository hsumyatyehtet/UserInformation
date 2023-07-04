package com.hmyh.userinfo.ui.screens.userlistscreen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.hmyh.userinfo.R
import com.hmyh.userinfo.ui.screens.userdetailscreen.launchUserDetail
import com.hmyh.userinfo.ui.theme.UserInfoTheme

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
                    //Toast.makeText(this,it.name,Toast.LENGTH_SHORT).show()
                    launchUserDetail(this, it)
                })
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UserInfoTheme {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(id = R.color.colorLightBlue900)
        ) {
            //UserListScreen()
        }
    }
}