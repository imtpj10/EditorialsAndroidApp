package com.example.editorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showNewsListFragment()
    }

    private fun showNewsListFragment() {
        val tag = "NewsListFragment"
        val existingFragmentWithTag = supportFragmentManager.findFragmentByTag(tag)

        if(existingFragmentWithTag == null) {
            supportFragmentManager.beginTransaction().add(R.id.newsListFragmentContainer,NewsListFragment(),tag).commit()
        }
    }
}