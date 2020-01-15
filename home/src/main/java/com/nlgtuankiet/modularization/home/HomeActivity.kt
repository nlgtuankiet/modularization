package com.nlgtuankiet.modularization.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.nlgtuankiet.modularization.common.IntentProvider
import com.nlgtuankiet.modularization.common.StarterIntents
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var intentProvider: IntentProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        findViewById<Button>(R.id.go_to_detail_button).setOnClickListener {
            val id = findViewById<EditText>(R.id.editText).text?.toString() ?: ""
            val intent = intentProvider.detailIntent(this, id)
            startActivity(intent)
        }
    }

    class StarterIntent @Inject constructor() : StarterIntents.Home {
        override fun home(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}
