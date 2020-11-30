package com.mei.dong.multi_users_automotive

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.*

class ReadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reading)
        readFile()
    }

    private fun readFile() {
        val view = findViewById<TextView>(R.id.textView)
        val value = readFromFile(applicationContext)
        view.setText(value)
    }

    private fun readFromFile(context: Context): String? {
        var ret = ""
        try {
            val inputStream: InputStream = context.openFileInput("config.txt")
            if (inputStream != null) {
                val inputStreamReader = InputStreamReader(inputStream)
                val bufferedReader = BufferedReader(inputStreamReader)
                var receiveString: String? = ""
                val stringBuilder = StringBuilder()
                while (bufferedReader.readLine().also({ receiveString = it }) != null) {
                    stringBuilder.append("\n").append(receiveString)
                }
                inputStream.close()
                ret = stringBuilder.toString()
            }
        } catch (e: FileNotFoundException) {
            Log.e("login activity", "File not found: " + e.toString())
        } catch (e: IOException) {
            Log.e("login activity", "Can not read file: " + e.toString())
        }
        return ret
    }
//    private fun readFileAsTextUsingInputStream(fileName: String)
//            = File(cacheDir, "myfile.txt").inputStream().readBytes().toString(Charsets.UTF_8)
}