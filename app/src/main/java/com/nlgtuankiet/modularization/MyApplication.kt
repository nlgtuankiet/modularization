package com.nlgtuankiet.modularization

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class MyApplication : DaggerApplication(), HasCoreComponent {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        appComponent = DaggerAppComponent.factory().create(this)
        super.onCreate()
        runCatching {
            Class.forName("com.nlgtuankiet.modularization.checkout.CheckoutInitializer")
                .newInstance() as Initializer
        }.getOrNull()?.init()

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }

    override val coreComponent: CoreComponent
        get() = appComponent
}