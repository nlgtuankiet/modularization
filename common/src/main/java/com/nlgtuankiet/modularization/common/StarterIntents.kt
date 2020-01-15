package com.nlgtuankiet.modularization.common

import android.content.Context
import android.content.Intent
import dagger.BindsOptionalOf
import dagger.Module

@Module
interface StarterIntents {
    interface Detail {
        fun detail(context: Context, productId: String): Intent
    }

    interface Home {
        fun home(context: Context): Intent
    }

    interface Search {
        fun search(context: Context, keyword: String?): Intent
    }

    @BindsOptionalOf
    fun detail(): Detail

    @BindsOptionalOf
    fun home(): Home

    @BindsOptionalOf
    fun search(): Search
}