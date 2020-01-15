package com.nlgtuankiet.modularization

import android.content.Context
import android.content.Intent
import com.google.common.base.Optional
import com.nlgtuankiet.modularization.common.IntentProvider
import com.nlgtuankiet.modularization.common.StarterIntents
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IntentProviderImpl @Inject constructor(
    private val home: Optional<StarterIntents.Home>,
    private val detail: Optional<StarterIntents.Detail>,
    private val search: Optional<StarterIntents.Search>
) : IntentProvider {
    override fun search(context: Context, keyword: String?): Intent {
        return search.makeIntent { search(context, keyword) }
    }

    override fun homeIntent(context: Context): Intent {
        return home.makeIntent { home(context) }
    }

    override fun detailIntent(context: Context, productId: String): Intent {
        return detail.makeIntent { detail(context, productId) }
    }

    private fun <T> Optional<T>.makeIntent(block: T.() -> Intent): Intent {
        if (isPresent) {
            return get().block()
        }
        // return some secret activity that only present debug build!
        throw IllegalStateException()
    }
}