package com.example.di

import android.content.Context
import androidx.room.Room
import com.example.data.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class DatabaseModule{

    @Provides
    @Singleton
    fun provideDataBase(
        context: Context
    ): Database {
        return Room.databaseBuilder(
            context,
            Database::class.java,
            "product_database"
        ).build()
    }
}