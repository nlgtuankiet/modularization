package com.nlgtuankiet.modularization.checkout

import android.content.Context
import android.content.Intent
import androidx.annotation.Keep
import com.nlgtuankiet.modularization.Initializer

@Keep
class CheckoutInitializer : Initializer {
    override fun init() {
        CheckoutDelegate.checkoutActivityDelegate = object : CheckoutActivityDelegate {
            override fun newIntent(context: Context, productIds: Array<String>): Intent {
                return CheckoutActivity.newIntent(context, productIds)
            }
        }
    }
}