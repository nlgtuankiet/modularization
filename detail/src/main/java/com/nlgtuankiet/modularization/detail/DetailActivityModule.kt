package com.nlgtuankiet.modularization.detail

import com.nlgtuankiet.modularization.common.StarterIntents
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface DetailActivityModule {

    @ContributesAndroidInjector
    fun activity(): DetailActivity

    @Binds
    fun starterIntent(impl: DetailActivity.StarterIntent): StarterIntents.Detail
}