package com.hmyh.userinfo.di

import android.content.Context
import com.google.gson.GsonBuilder
import com.hmyh.userinfo.network.UserInfoApi
import com.hmyh.userinfo.network.UserRemoteDataSource
import com.hmyh.userinfo.persistance.UserListDatabase
import com.hmyh.userinfo.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(
        @ApplicationContext context: Context
    ): UserInfoApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(UserInfoApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): UserListDatabase {
        return UserListDatabase.getDatabase(appContext)
    }

    @Provides
    @Singleton
    fun provideUserRemoteDataSource(api: UserInfoApi): UserRemoteDataSource {
        return UserRemoteDataSource(api)
    }


}