package com.hmyh.userinfo.utils

import com.hmyh.userinfo.data.vos.UserListVO

fun getUserList(): MutableList<UserListVO>{
    return mutableListOf(
        UserListVO(1,"Hsu Myat Ye Htet","hsumyatyehtet","hsumyatyehtet@gmail.com"),
        UserListVO(2,"Developer Hmyh","devhmyh","hsumyatyehtet.dev@gmail.com"),
        UserListVO(3,"Limm Hyayng Phyo","limmphyo","limmhyayngphyo@gmail.com")
    )
}