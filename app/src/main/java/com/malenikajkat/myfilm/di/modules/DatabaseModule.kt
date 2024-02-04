package com.malenikajkat.myfilm.di.modules
import com.malenikajkat.myfilm.data.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideRepository() = MainRepository()
}