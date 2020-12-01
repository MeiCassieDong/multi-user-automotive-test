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
        Log.d("Mei", "ReadingActivity set to value view")
        readFile()
    }

    private fun readFile() {
        val view = findViewById<TextView>(R.id.textView)
        //val value = readFileAsTextUsingInputStream("config.txt")
        val value = readFromFile(applicationContext)
        Log.d("Mei ReadingActivity set to value view", value)
        view.setText(value)
    }

    private fun readFromFile(context: Context): String? {
        var ret = ""
        try {
            Log.d("Mei", " readFromFile")
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
                Log.d("Mei", " readFromFile $ret")
            }
        } catch (e: FileNotFoundException) {
            Log.e("ReadingActivity", "File not found: " + e.toString())
        } catch (e: IOException) {
            Log.e("ReadingActivity", "Can not read file: " + e.toString())
        }
        return ret
    }
    private fun readFileAsTextUsingInputStream(fileName: String)
            = File("data/data/com.mei.dong.multi_users_automotive/files", fileName).inputStream().readBytes().toString(Charsets.UTF_8)
}