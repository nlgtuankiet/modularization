package com.nlgtuankiet.modularization.checkout

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nlgtuankiet.modularization.NumberRepository
import javax.inject.Inject

class CheckoutActivity : AppCompatActivity() {

    @Inject
    lateinit var numberRepository: NumberRepository

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        CheckoutComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
        val ids = intent.getStringArrayExtra("ids") ?: emptyArray()

        val randomNumber = numberRepository.getRandomNumber()

        findViewById<TextView>(R.id.content).text = """
                checkout screen for
                ${ids.toList()}
                random number: $randomNumber
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