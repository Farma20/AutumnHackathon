package com.example.autumnhackathon.di

import com.example.autumnhackathon.data.repositories.SingInHackathonRepository
import com.example.autumnhackathon.data.repositories.UserDataHackathonRepository
import com.example.autumnhackathon.domain.repositories.SingInRepository
import com.example.autumnhackathon.domain.repositories.UserDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindSingInRepository(
        singInRepository: SingInHackathonRepository
    ): SingInRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        userRepository: UserDataHackathonRepository
    ): UserDataRepository


}