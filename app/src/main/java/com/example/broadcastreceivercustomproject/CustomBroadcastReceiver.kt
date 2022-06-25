package com.example.broadcastreceivercustomproject

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class CustomBroadcastReceiver : BroadcastReceiver() {

    lateinit var connectivityManager: ConnectivityManager

    override fun onReceive(context: Context, intent: Intent) {


        if(isOnline(context)){
            Toast.makeText(context, "Internet connected", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Internet not connected", Toast.LENGTH_SHORT).show()
        }
    }

    fun isOnline(context:Context):Boolean {
        connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return (networkInfo!=null && networkInfo.isConnected)
    }
}