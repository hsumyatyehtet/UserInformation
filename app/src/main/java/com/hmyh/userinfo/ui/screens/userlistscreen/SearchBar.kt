package com.hmyh.userinfo.ui.screens.userlistscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hmyh.userinfo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    value: String,
    onValueChange: (String) -> Unit
) {

    var text by remember { mutableStateOf(value) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(25.dp))
        ) {

            TextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                    onValueChange(newText)
                },

                modifier = Modifier
                    .heightIn(min = 46.dp, max = 48.dp)
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .background(color = Color.Transparent),
                placeholder = {
                    Text(
                        text = "Search by name",
                        color = colorResource(id = R.color.colorSecondaryText),
                        fontSize = 12.sp
                    )

                },
                shape = RoundedCornerShape(26.dp),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = colorResource(id = R.color.colorPrimaryText),
                    containerColor = colorResource(id = R.color.white),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                leadingIcon = {
                    Icon(Icons.Filled.Search, contentDescription = "")

                }

            )
        }

    }


}

@Preview
@Composable
fun SearchBarPreview() {

    var textValue by remember {
        mutableStateOf("")
    }

    SearchBar(
        value = textValue,
        onValueChange = {
            textValue = it
        }
    )
}