package com.hmyh.userinfo.persistance

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hmyh.userinfo.data.vos.UserListVO
import com.hmyh.userinfo.persistance.daos.UserListDao

@Database(
    entities = [UserListVO::class],
    version = 1,
    exportSchema = false
)
abstract class UserListDatabase : RoomDatabase() {

    abstract fun userListDao(): UserListDao

}