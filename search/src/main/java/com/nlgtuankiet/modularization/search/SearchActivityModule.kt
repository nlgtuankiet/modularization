package com.nlgtuankiet.modularization.search

import com.nlgtuankiet.modularization.common.StarterIntents
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface SearchActivityModule {
    @ContributesAndroidInjector
    fun activity(): SearchActivity

    @Binds
    fun starterIntent(impl: SearchActivity.StarterIntent): StarterIntents.Search
}