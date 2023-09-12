package com.nlgtuankiet.modularization

import android.content.Context

interface CoreComponent {
    val numberRepository: NumberRepository
}

interface HasCoreComponent {
    val coreComponent: CoreComponent
}

val Context.coreComponent: CoreComponent
    get() = (applicationContext as HasCoreComponent).coreComponent