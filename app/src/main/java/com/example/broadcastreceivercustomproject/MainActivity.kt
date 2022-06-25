package com.example.broadcastreceivercustomproject

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val receiver = CustomBroadcastReceiver()
        registerNetworkBroadcastReceiver(receiver);
    }

    fun registerNetworkBroadcastReceiver(receiver: CustomBroadcastReceiver){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            registerReceiver(receiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        }
    }
}