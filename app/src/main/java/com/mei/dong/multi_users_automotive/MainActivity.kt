package com.mei.dong.multi_users_automotive

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.UserHandle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonActivity = findViewById<Button>(R.id.buttonActivity)
        buttonActivity.setOnClickListener{
            startActivity(Intent(this, ReadingActivity::class.java))
        }
        val buttonService = findViewById<Button>(R.id.buttonService)
        buttonService.setOnClickListener{
            startService()
        }
    }

    private fun startReadingActivity() {
        try {
            val usr0Handle = UserHandle.getUserHandleForUid(0)
            val hiddenMethod = Context::class.java.getMethod("startActivityAsUser", Intent::class.java, UserHandle::class.java)
            hiddenMethod.invoke(applicationContext, Intent(this, ReadingActivity::class.java), usr0Handle)
            Log.d("Mei", "hiddenMethod.invoke")
        } catch (e : Exception) {
            Log.d("Mei", " launching ReadingActivity failed ${e.message}")
            e.printStackTrace()
        }
        Log.d("Mei", " launching ReadingActivity")

        //      startActivity(Intent(this, ReadingActivity::class.java))
    }

    private fun startReadingActivityWithUserAll() {
        try {
            val hiddenField = UserHandle::class.java.getDeclaredField("ALL")
            hiddenField.isAccessible = true
            val hiddenMethod = Context::class.java.getMethod("startActivityAsUser", Intent::class.java, UserHandle::class.java)
            hiddenMethod.invoke(applicationContext, Intent(this, ReadingActivity::class.java), hiddenField)
            Log.d("Mei", "hiddenMethod.invoke")
        } catch (e : Exception) {
            Log.d("Mei", " launching ReadingActivity failed ${e.message}")
            e.printStackTrace()
        }
        Log.d("Mei", " launching ReadingActivity")

        //      startActivity(Intent(this, ReadingActivity::class.java))
    }

    private fun startServiceWithUserAll() {
        try {
            val hiddenField = UserHandle::class.java.getDeclaredField("ALL")
            hiddenField.isAccessible = true
            val hiddenMethod = Context::class.java.getMethod("startForegroundServiceAsUser", Intent::class.java, UserHandle::class.java)
            hiddenMethod.invoke(applicationContext, Intent(this, BackgroundService::class.java), hiddenField)
            Log.d("Mei", "hiddenMethod.invoke")
        } catch (e : Exception) {
            Log.d("Mei", " launching service failed ${e.message}")
            e.printStackTrace()
        }
    }

    private fun startServiceWithUser0() {
        try {
            val usr0Handle = UserHandle.getUserHandleForUid(0)
            val hiddenMethod = Context::class.java.getMethod("startForegroundServiceAsUser", Intent::class.java, UserHandle::class.java)
            hiddenMethod.invoke(applicationContext, Intent(this, BackgroundService::class.java), usr0Handle)
            Log.d("Mei", "hiddenMethod.invoke")
        } catch (e : Exception) {
            Log.d("Mei", " launching service failed ${e.message}")
            e.printStackTrace()
        }
        Log.d("Mei", " launching service")
    }

    private fun startService() {
        //ToDo: start service with UserHandle.ALL
        applicationContext.startForegroundService(Intent(this, BackgroundService::class.java))
    }
}