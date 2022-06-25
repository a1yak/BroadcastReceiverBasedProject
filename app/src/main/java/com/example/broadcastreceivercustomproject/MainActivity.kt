package com.example.broadcastreceivercustomproject

import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import com.example.broadcastreceivercustomproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val intentFilter = IntentFilter()
    private val SmsReceiver = CustomBroadcastReceiver(){
        @Override
        fun onReceive(){
            binding.tvReceivedMsg.text=intent.extras?.getString("Messaga")
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        intentFilter.addAction("SMS_RECEIVED_ACTION")
        registerNetworkBroadcastReceiver(SmsReceiver)
        binding.btnSend.setOnClickListener { sendMesage() }
    }

    fun sendMesage(){
        val message: String = binding.tvMessage.text.toString()
        val adressNumber: String =binding.tvAdress.text.toString()
        var sentPI: PendingIntent = PendingIntent.getBroadcast(this,0, Intent("Message sent"),0)
        var receivedPI: PendingIntent = PendingIntent.getBroadcast(this,0, Intent("Message delivered"),0)
        val sms = SmsManager.getDefault()
        sms.sendTextMessage(adressNumber, null, message, sentPI,receivedPI)
    }

    fun registerNetworkBroadcastReceiver(receiver: CustomBroadcastReceiver){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            registerReceiver(receiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        }

        @Override
        fun onPause(){
            super.onPause()
            unregisterReceiver(SmsReceiver)
        }

        @Override
        fun onResume(){
            super.onResume()
            registerReceiver(SmsReceiver, intentFilter)
        }
    }
}