package com.hmyh.userinfo.ui.screens.userdetailscreen

import android.widget.ImageView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Email
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hmyh.userinfo.R

@Composable
fun UserInformationDetailItem(
    title: String,
    dataText: String,
    icon: ImageVector
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 32.dp),
    ) {
        Card(
            modifier = Modifier
                .size(45.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 12.dp
            ),
            shape = CircleShape,
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.white),
            )
        ) {
            BoxWithConstraints(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    tint = colorResource(id = R.color.colorLightBlue900)
                )
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp)
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.colorSecondaryText),
                    fontWeight = FontWeight.Normal
                )
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = dataText,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.colorPrimaryText),
                    fontWeight = FontWeight.Bold
                )
            )
        }

    }

}