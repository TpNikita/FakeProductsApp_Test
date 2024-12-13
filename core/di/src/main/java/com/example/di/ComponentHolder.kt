package com.example.di

import android.content.Context
import kotlin.reflect.KClass

class ComponentHolder(val context: Context) {

    private val components = mutableMapOf<KClass<out CoreComponent>, CoreComponent>()

    @Suppress("UNCHECKED_CAST")
    fun <T : CoreComponent> get(
        key: KClass<out T>,
        builder: (Context) -> T
    ): T {
        return components.getOrPut(key) { builder.invoke(context) } as T
    }
}