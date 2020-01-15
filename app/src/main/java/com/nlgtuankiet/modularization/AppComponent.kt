package com.nlgtuankiet.modularization

import com.nlgtuankiet.modularization.common.IntentProvider
import com.nlgtuankiet.modularization.common.StarterIntents
import com.nlgtuankiet.modularization.detail.DetailActivityModule
import com.nlgtuankiet.modularization.home.HomeActivityModule
import com.nlgtuankiet.modularization.search.SearchActivityModule
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        StarterIntents::class,
        HomeActivityModule::class,
        DetailActivityModule::class,
        SearchActivityModule::class,
        DeepLinkDispatcherActivity.Module::class,
        AppComponent.Binding::class
    ]
)
interface AppComponent : AndroidInjector<MyApplication> {

    fun intentProviderImpl(): IntentProviderImpl

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance myApplication: MyApplication): AppComponent
    }

    @Module
    interface Binding {
        @Binds
        fun intentProvider(impl: IntentProviderImpl): IntentProvider
    }
}

