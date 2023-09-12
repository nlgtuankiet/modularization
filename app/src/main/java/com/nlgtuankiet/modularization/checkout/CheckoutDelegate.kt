package com.nlgtuankiet.modularization.checkout

import android.content.Context
import android.content.Intent

object CheckoutDelegate {
    lateinit var checkoutActivityDelegate: CheckoutActivityDelegate
}

interface CheckoutActivityDelegate {
    fun newIntent(context: Context, productIds: Array<String>): Intent
}