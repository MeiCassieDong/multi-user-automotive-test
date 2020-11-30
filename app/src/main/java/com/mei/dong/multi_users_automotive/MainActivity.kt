package com.mei.dong.multi_users_automotive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startService()
    }

    override fun onResume() {
        super.onResume()
        //ToDo: start activity with UserHandle.ALL
        startActivity(Intent(this, ReadingActivity::class.java))
    }

    private fun startService() {
        //ToDo: start service with UserHandle.ALL
        applicationContext.startService(Intent(this, BackgroundService::class.java))
    }
}