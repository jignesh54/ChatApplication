package com.example.chatapplication

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MessageAdapter(val context:Context,val messageList:ArrayList<Message>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }

    class SentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
    class ReceiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }


}