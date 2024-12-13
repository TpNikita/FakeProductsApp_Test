package com.example.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    //@Singleton
    fun provideProduct(): Retrofit {
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://fakestoreapi.com/")
            .build()
        return retrofit
    }
}