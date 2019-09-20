package com.example.recyclerview

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {


    var myBluetooth: BluetoothAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnPaired: Button = findViewById(R.id.button)

        val devicelist = findViewById<RecyclerView>(R.id.recyclerView1)
        devicelist.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)



        myBluetooth = BluetoothAdapter.getDefaultAdapter()
        if (myBluetooth == null) {
            //Show a mensag. that thedevice has no bluetooth adapter
            Toast.makeText(applicationContext, "Bluetooth Device Not Available", Toast.LENGTH_LONG)
                .show()
            //finish apk
            finish()
        } else {
            if (myBluetooth!!.isEnabled) {
            } else {
                //Ask to the user turn the bluetooth on
                val turnBTon = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivityForResult(turnBTon, 1)
            }
        }



        fun pairedDevicesList() {
            val pairedDevices = myBluetooth?.bondedDevices
            val list = ArrayList<User>()

            if (pairedDevices?.isNotEmpty()!!) {
                for (bt in pairedDevices) {
                    list.add(
                        User(
                            name = bt.name,
                            address = bt.address
                        )
                    ) //Get the device's name and the address
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    "No Paired Bluetooth Devices Found.",
                    Toast.LENGTH_LONG
                ).show()
            }


            val adapter = CustomAdapter(list)
            devicelist.adapter = adapter
        }

            btnPaired.setOnClickListener {
                pairedDevicesList()
            }

    }

    companion object {
        var EXTRA_ADDRESS = ""
    }
}

