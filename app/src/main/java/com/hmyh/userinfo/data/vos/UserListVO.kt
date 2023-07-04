package com.hmyh.userinfo.data.vos

import androidx.compose.runtime.Immutable

@Immutable
data class UserListVO(

    var id: Int? = null,

    var name: String? = null,

    var userName: String? = null,

    var email: String?=null

)