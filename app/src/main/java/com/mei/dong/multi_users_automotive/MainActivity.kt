package com.mei.dong.multi_users_automotive

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import android.util.Log
import java.lang.Exception
import java.util.logging.Level.ALL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startService()
    }

    override fun onResume() {
        super.onResume()
        //ToDo: start activity with UserHandle.ALL
//        try {
//            val usr0Handle = UserHandle.getUserHandleForUid(0)
//            val hiddenMethod = Context::class.java.getMethod("startActivityAsUser", Intent::class.java, UserHandle::class.java)
//            hiddenMethod.invoke(applicationContext, Intent(this, ReadingActivity::class.java), usr0Handle)
//        } catch (e : Exception) {
//            e.printStackTrace()
//        }
        startActivity(Intent(this, ReadingActivity::class.java))
    }

    private fun startService() {
        //ToDo: start service with UserHandle.ALL
        applicationContext.startForegroundService(Intent(this, BackgroundService::class.java))
    }
}