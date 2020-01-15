package com.nlgtuankiet.modularization.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.nlgtuankiet.modularization.common.StarterIntents
import dagger.android.support.DaggerAppCompatActivity

import kotlinx.android.synthetic.main.activity_search.*
import javax.inject.Inject

class SearchActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setSupportActionBar(toolbar)

        val keyword = intent.getStringExtra("keyword") ?: ""
        findViewById<EditText>(R.id.editText).setText(keyword)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    class StarterIntent @Inject constructor() : StarterIntents.Search {
        override fun search(context: Context, keyword: String?): Intent {
            return Intent(context, SearchActivity::class.java).apply {
                putExtra("keyword", keyword)
            }
        }
    }

}
