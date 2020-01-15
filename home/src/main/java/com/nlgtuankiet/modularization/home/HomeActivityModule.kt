package com.nlgtuankiet.modularization.home

import com.nlgtuankiet.modularization.common.StarterIntents
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface HomeActivityModule {
    @ContributesAndroidInjector
    fun activity(): HomeActivity

    @Binds
    fun startIntent(impl: HomeActivity.StarterIntent): StarterIntents.Home
}