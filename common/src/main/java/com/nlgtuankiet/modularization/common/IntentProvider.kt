package com.nlgtuankiet.modularization.common

import android.content.Context
import android.content.Intent

interface IntentProvider {
    fun homeIntent(context: Context): Intent
    fun detailIntent(context: Context, productId: String): Intent
    fun search(context: Context, keyword: String?): Intent
}