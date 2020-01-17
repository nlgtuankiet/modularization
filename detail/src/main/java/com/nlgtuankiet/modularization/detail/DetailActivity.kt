package com.nlgtuankiet.modularization.detail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.Keep
import com.nlgtuankiet.modularization.NumberRepository
import com.nlgtuankiet.modularization.common.IntentProvider
import com.nlgtuankiet.modularization.common.StarterIntents
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DetailActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var intentProvider: IntentProvider

    @Inject
    lateinit var numberRepository: NumberRepository

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val id = intent?.getStringExtra("productId")
        findViewById<TextView>(R.id.content).text =
            """
                product detail page for id: $id
                random number is: ${numberRepository.getRandomNumber()}
            """.trimIndent()

        findViewById<Button>(R.id.to_home_button).setOnClickListener {
            val intent = intentProvider.homeIntent(this)
            startActivity(intent)
        }
    }

//    companion object { // legacy code
//        @JvmStatic
//        @Keep
//        fun starterIntent(context: Context, productId: String): Intent {
//            return Intent(context, DetailActivity::class.java).apply {
//                putExtra("productId", productId)
//            }
//        }
//    }

    class StarterIntent @Inject constructor() : StarterIntents.Detail {

        override fun detail(context: Context, productId: String): Intent {
            return Intent(context, DetailActivity::class.java).apply {
                putExtra("productId", productId)
            }
        }

    }
}
