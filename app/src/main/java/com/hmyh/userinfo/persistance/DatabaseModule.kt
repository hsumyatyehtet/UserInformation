package com.hmyh.userinfo.persistance

import android.app.Application
import androidx.room.Room
import com.hmyh.userinfo.persistance.daos.UserListDao
import com.hmyh.userinfo.utils.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): UserListDatabase {
        return Room.databaseBuilder(application, UserListDatabase::class.java, DB_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideUserListDao(database: UserListDatabase): UserListDao{
        return database.userListDao()
    }

}