package com.nlgtuankiet.modularization.checkout

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nlgtuankiet.modularization.R

class CheckoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
        val ids = intent.getStringArrayExtra("ids") ?: emptyArray()
        @SuppressLint("SetTextI18n")
        findViewById<TextView>(R.id.content).text = """
                checkout screen for
                ${ids.toList()}
            """.trimIndent()
    }

    companion object {
        fun newIntent(context: Context, productIds: Array<String>): Intent {
            val intent = Intent(context, CheckoutActivity::class.java)
            intent.putExtra("ids", productIds)
            return intent
        }
    }
}