package com.hmyh.userinfo.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hmyh.userinfo.data.vos.UserListVO
import com.hmyh.userinfo.persistance.daos.UserListDao
import com.hmyh.userinfo.utils.DB_NAME

@Database(
    entities = [UserListVO::class],
    version = 1,
    exportSchema = false
)
abstract class UserListDatabase : RoomDatabase() {

    abstract fun userListDao(): UserListDao

    companion object {

        @Volatile
        private var INSTANCE: UserListDatabase? = null

        fun getDatabase(context: Context): UserListDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                UserListDatabase::class.java, DB_NAME
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

    }

}