package com.malenikajkat.myfilm

import android.app.Application
import com.malenikajkat.myfilm.di.AppComponent
import com.malenikajkat.myfilm.di.DaggerAppComponent
import com.malenikajkat.myfilm.di.modules.DatabaseModule
import com.malenikajkat.myfilm.di.modules.DomainModule
import com.malenikajkat.myfilm.di.modules.RemoteModule

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}