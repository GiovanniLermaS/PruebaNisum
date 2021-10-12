package com.example.pruebanisum.view

import com.example.pruebanisum.repository.IMainActivityRepository
import com.example.pruebanisum.repository.MainActivityRepository
import com.example.pruebanisum.retrofit.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class MainModule {
    @Provides
    fun provideAboutRepository(apiInterface: ApiInterface): IMainActivityRepository {
        return MainActivityRepository(apiInterface)
    }
}