package com.example.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class NetworkModule {

    @Provides
    //@Singleton
    fun provideProduct(): Retrofit {

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit
    }
}