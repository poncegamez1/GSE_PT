package com.example.gse_pt.di

import com.example.gse_pt.api.Api
import com.example.gse_pt.repository.imp.UserRepositoryImp
import com.example.gse_pt.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object RepositoryModule {

    @Provides
    @Singleton
    fun providesUserRepository(api:Api): UsersRepository{
        return UserRepositoryImp(api)
    }

}