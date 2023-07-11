package com.hmyh.userinfo.persistance

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.hmyh.userinfo.persistance.daos.UserListDao
import com.hmyh.userinfo.utils.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): UserListDatabase {
        return UserListDatabase.getDatabase(appContext)
    }

    @Provides
    fun provideUserListDao(database: UserListDatabase): UserListDao{
        return database.userListDao()
    }

}