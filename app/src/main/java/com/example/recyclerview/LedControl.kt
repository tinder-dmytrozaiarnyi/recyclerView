package com.example.recyclerview

import android.app.ProgressDialog
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.CustomAdapter.Companion.appContext
import kotlinx.android.synthetic.main.activity_led_control.*
import java.io.IOException
import java.util.*
import android.widget.SeekBar




class LedControl : AppCompatActivity() {

    fun msg(s: String) {
        Toast.makeText(applicationContext, s, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_led_control)
    }
//
//        val newint = intent
//        val address = newint.getStringExtra(MainActivity.EXTRA_ADDRESS)
//
//        val btnOn = button2
//        val btnOff = button3
//        val btnDis = button4
//        val brightness = seekBar
//
//
//        lateinit var myBluetooth: BluetoothAdapter
//        lateinit var btSocket: BluetoothSocket
//        var isBtConnected = false
//        val myUUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
//
//
//        class ConnectBT : AsyncTask<Void, Void, Void>() {
//
//
//            lateinit var progress: ProgressDialog
//            private var connectSuccess = true
//            //if it's here, it's almost connected
//
//
//            override fun onPreExecute() {
//                progress = ProgressDialog.show(
//                    appContext,
//                    "Connecting...",
//                    "Please wait!!!"
//                )  //show a progress dialog
//            }
//
//            override fun doInBackground(vararg params: Void): Void? {
//                try {
//                    if (btSocket == null || !isBtConnected) {
//                        //get the mobile bluetooth device
//                        myBluetooth = BluetoothAdapter.getDefaultAdapter()
//                        //connects to the device's address and checks if it's available
//                        val dispositivo: BluetoothDevice = myBluetooth.getRemoteDevice(address)
//                        //create a RFCOMM (SPP) connection
//                        btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID)
//                        BluetoothAdapter.getDefaultAdapter().cancelDiscovery()
//                        //start connection
//                        btSocket.connect()
//                    }
//                } catch (e: IOException) {
//                    connectSuccess = false//if the try failed, you can check the exception here
//                }
//                return null
//            }
//
//            @Override
//            override fun onPostExecute(result: Void) {
//                //after the doInBackground, it checks if everything went fine
//
//                super.onPostExecute(result)
//
//                if (!connectSuccess) {
//                    msg("Connection Failed. Is it a SPP Bluetooth? Try again.")
//                    finish()
//                } else {
//                    msg("Connected.")
//                    isBtConnected = true
//                }
//                progress.dismiss()
//
//
//                fun disconnect() {
//                    if (btSocket != null)
//                    //If the btSocket is busy
//                    {
//                        try {
//                            btSocket.close() //close connection
//                        } catch (e: IOException) {
//                            msg("Error")
//                        }
//
//                    }
//                    finish() //return to the first layout
//                }
//
//                fun turnOffLed() {
//                    if (btSocket != null) {
//                        try {
//                            btSocket.outputStream.write("TF".toByteArray())
//                        } catch (e: IOException) {
//                            msg("Error")
//                        }
//
//                    }
//                }
//
//                fun turnOnLed() {
//                    if (btSocket != null) {
//                        try {
//                            btSocket.outputStream.write("TO".toByteArray())
//                        } catch (e: IOException) {
//                            msg("Error")
//                        }
//
//                    }
//                }
//
//                btnOn.setOnClickListener {
//                    turnOnLed()
//                }
//
//                btnOff.setOnClickListener {
//                    turnOffLed()
//                }
//
//                btnDis.setOnClickListener {
//                    disconnect()
//                }
//
//                brightness.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
//                    override fun onProgressChanged(
//                        seekBar: SeekBar,
//                        progress: Int,
//                        fromUser: Boolean
//                    ) {
//                        if (fromUser == true) {
//                            try {
//                                btSocket.outputStream.write(progress.toString().toByteArray())
//                            } catch (e: IOException) {
//
//                            }
//
//                        }
//                    }
//
//                    override fun onStartTrackingTouch(seekBar: SeekBar) {
//
//                    }
//                    override fun onStopTrackingTouch(seekBar: SeekBar) {
//
//                    }
//                })
//            }
//
//        }
//
//    }

}


