package com.example.fakeproductsapp.main

import android.app.Application
import com.example.di.ComponentHolder
import com.example.di.ComponentHolderProvider

class MainApp : Application(), ComponentHolderProvider {

    private val localComponentList: ComponentHolder = ComponentHolder(this)

    override fun onCreate() {
        super.onCreate()
    }

    override val componentHolder: ComponentHolder
        get() = localComponentList
}