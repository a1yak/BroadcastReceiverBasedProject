package com.example.broadcastreceivercustomproject

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Message
import android.widget.Toast
import android.telephony.SmsMessage
import java.util.*

class CustomBroadcastReceiver(function: () -> Unit) : BroadcastReceiver() {

    lateinit var connectivityManager: ConnectivityManager
    var counter = 0

    override fun onReceive(context: Context, intent: Intent) {

       val broadcastIntent = Intent()
        val bundle = intent.getBundleExtra("pdu")
        var message = arrayOf<SmsMessage>()
        var string = ""
        if(bundle!=null) {
            var pdu: ByteArray? = bundle.getByteArray("pdu")
            while (counter< pdu?.size!!) {
                message[counter] = SmsMessage.createFromPdu(pdu)
                string += message[counter].displayOriginatingAddress
                string += ": "
                string += message[counter].messageBody
                counter++
            }
        }

        Toast.makeText(context,string,Toast.LENGTH_SHORT).show()
        broadcastIntent.putExtra("Message", string)
        broadcastIntent.setAction("SMS_RECEIVED_ACTION")
        context.sendBroadcast(broadcastIntent)
    }
}



      /*  if(isOnline(context)){
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
}*/