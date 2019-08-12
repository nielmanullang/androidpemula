package com.danielmanullang.submission

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDataName: TextView = findViewById(R.id.tv_data_name)
        val tvDataHistory: TextView = findViewById(R.id.tv_data_history)
        val tvDataPhoto: ImageView = findViewById(R.id.tv_data_photo)

        val name = intent.getStringExtra(EXTRA_NAME)
        val history = intent.getStringExtra(EXTRA_HISTORY)
        val photo = intent.getStringExtra(EXTRA_PHOTO)

        setActionBarTitle(name?:"")

        Glide.with(this)
            .load(photo)
            .apply(RequestOptions().override(350, 350))
            .into(tvDataPhoto)

        tvDataName.text = name
        tvDataHistory.text = history
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_HISTORY = "extra_history"
        const val EXTRA_PHOTO = "extra_photo"
    }
}