package com.example.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class CustomAdapter(val userList: ArrayList<User>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v)
    }


    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(userList[position])

        holder.itemView.setOnClickListener {v ->
            // Get the device MAC address, the last 17 chars in the View
            val info = (v as TextView).text.toString()
            val address = info.substring(info.length - 17)
            // Make an intent to start next activity.
            //this will be received at ledControl (class) Activity
            val ledControlIntent = Intent(appContext, LedControl::class.java).apply {
                putExtra(MainActivity.EXTRA_ADDRESS, address)
            }
            startActivity(appContext, ledControlIntent, null)
        }
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: User) {
            val textViewName = itemView.findViewById(R.id.txtName) as TextView
            val textViewAddress  = itemView.findViewById(R.id.txtTitle) as TextView
            textViewName.text = user.name
            textViewAddress.text = user.address
        }
    }

    companion object {
        lateinit  var appContext: Context
    }

}