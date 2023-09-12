package com.nlgtuankiet.modularization.checkout

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface CheckoutModule {

    @ContributesAndroidInjector
    fun activity(): CheckoutActivity
}