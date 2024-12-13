package com.example.di

import android.content.Context
import com.example.di.ComponentHolder
import com.example.di.ComponentHolderProvider



interface CoreComponent {

    companion object {
        fun getComponentHolder(context: Context): ComponentHolder {
            return (context.applicationContext as ComponentHolderProvider).componentHolder
        }
    }
}