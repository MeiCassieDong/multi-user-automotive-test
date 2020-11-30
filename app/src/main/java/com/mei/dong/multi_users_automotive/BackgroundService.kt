package com.mei.dong.multi_users_automotive

import android.app.Notification
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.annotation.CallSuper
import java.io.IOException
import java.io.OutputStreamWriter

class BackgroundService : Service() {


    @CallSuper
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        writeToFile("My Line", applicationContext)
        return START_NOT_STICKY
    }

    override fun onCreate() {
        super.onCreate()
        startForeground(1, Notification())
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

//    private fun writeFile() {
//        val fileName = "myfile.txt"
//        val myFile = File(cacheDir, fileName)
//
//        myFile.printWriter().use { out ->
//
//            out.println("one line")
//        }
//    }

    private fun writeToFile(data: String, context: Context) {
        try {
            val outputStreamWriter =
                OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE))
            outputStreamWriter.write(data)
            outputStreamWriter.close()
        } catch (e: IOException) {
            Log.e("Exception", "File write failed: " + e.toString())
        }
    }
}
