package com.viatom.traceroute

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.wandroid.traceroute.TraceRoute
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TraceRoute.setCallback {
            success { Log.d("tag", "\ntraceroute finish") }
            update { text -> Log.d("tag", text) }
            failed { code, reason -> Log.d("tag", """\ntraceroute failed.code:$code, reason:$reason""") }
        }
        TraceRoute.traceRoute("www.google.com", true)



    }
}