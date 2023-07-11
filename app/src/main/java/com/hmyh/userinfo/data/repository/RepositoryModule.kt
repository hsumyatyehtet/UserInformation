package com.hmyh.userinfo.data.repository

import com.hmyh.userinfo.network.UserRemoteDataSource
import com.hmyh.userinfo.persistance.UserListDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(userListDatabase: UserListDatabase,userRemoteDataSource: UserRemoteDataSource): UserRepository{
        return UserRepositoryImpl(userListDatabase.userListDao(),userRemoteDataSource)
    }

}