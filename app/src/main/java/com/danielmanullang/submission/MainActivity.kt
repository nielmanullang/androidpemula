package com.danielmanullang.submission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danielmanullang.submission.adapter.ListProgrammingLanguageAdapter
import com.danielmanullang.submission.model.ProgrammingLanguage

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rvProgrammingLanguage: RecyclerView
    private var list: ArrayList<ProgrammingLanguage> = arrayListOf()
    private var title: String = "Programming Language List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvProgrammingLanguage = findViewById(R.id.rv_programming_language)
        rvProgrammingLanguage.setHasFixedSize(true)

        list.addAll(ProgrammingLanguageData.listData)
        showRecyclerList()
    }

    override fun onClick(v: View) {
        when (v.id) {

        }
    }

    private fun showRecyclerList() {
        rvProgrammingLanguage.layoutManager = LinearLayoutManager(this)
        val listProgrammingLanguageAdapter = ListProgrammingLanguageAdapter(list)
        rvProgrammingLanguage.adapter = listProgrammingLanguageAdapter

        listProgrammingLanguageAdapter.setOnItemClickCallback(object : ListProgrammingLanguageAdapter.OnItemClickCallback {
            override fun onItemClicked(data: ProgrammingLanguage) {
                val moveWithDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
                moveWithDataIntent.putExtra(DetailActivity.EXTRA_NAME, data.name)
                moveWithDataIntent.putExtra(DetailActivity.EXTRA_HISTORY, data.history)
                moveWithDataIntent.putExtra(DetailActivity.EXTRA_PHOTO, data.photo)
                startActivity(moveWithDataIntent)
            }
        })
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return setMode(item.itemId)
    }

    private fun setMode(selectedMode: Int): Boolean {
        return when (selectedMode) {
            R.id.profile -> {
                setActionBarTitle(title)
                val moveWithDataIntent = Intent(this@MainActivity, AboutActivity::class.java)
                moveWithDataIntent.putExtra(AboutActivity.EXTRA_NAME, "Daniel Manullang")
                moveWithDataIntent.putExtra(AboutActivity.EXTRA_EMAIL, "danielthmanullang@gmail.com")
                startActivity(moveWithDataIntent)
                true
            }
            else->{
                false
            }
        }
    }
}
