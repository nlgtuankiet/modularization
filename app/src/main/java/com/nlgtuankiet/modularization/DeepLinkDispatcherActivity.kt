package com.nlgtuankiet.modularization

import android.net.Uri
import android.os.Bundle
import com.nlgtuankiet.modularization.common.IntentProvider
import dagger.android.ContributesAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DeepLinkDispatcherActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var intentProvider: IntentProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val uri = intent.data!!
        val intent = when {
            uri.isHomeLink() -> intentProvider.homeIntent(this)
            uri.isDetailLink() -> {
                val id = uri.pathSegments.firstOrNull() ?: ""
                intentProvider.detailIntent(this, id)
            }
            uri.isSearchLink() -> {
                val keyword = uri.pathSegments.firstOrNull()
                intentProvider.search(this, keyword)
            }
            else -> intentProvider.homeIntent(this)
        }
        startActivity(intent)
        finish()
    }

    private fun Uri.isSearchLink(): Boolean {
        return this.host == "search"
    }


    private fun Uri.isHomeLink(): Boolean {
        return this.host == "home"
    }

    private fun Uri.isDetailLink(): Boolean {
        return this.host == "detail"
    }

    @dagger.Module
    interface Module {
        @ContributesAndroidInjector
        fun activity(): DeepLinkDispatcherActivity
    }
}