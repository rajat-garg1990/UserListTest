package com.application.userlisttest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.application.userlisttest.R
import com.application.userlisttest.retro.UserResponse
import com.squareup.picasso.Picasso

class UserRecyclerAdapter(var context: Context) :
    RecyclerView.Adapter<UserRecyclerAdapter.ViewHolder>() {
    private var list: List<UserResponse> = ArrayList()

    fun getUsers(list: List<UserResponse>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text= list[position].id.toString()
        holder.first.text=list[position].first_name
        holder.last.text=list[position].last_name
        holder.email.text=list[position].email
        Picasso.get().load(list[position].avatar).into(holder.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var id=view.findViewById<TextView>(R.id.userID)
        var image=view.findViewById<ImageView>(R.id.userImage)
        var first=view.findViewById<TextView>(R.id.userFirstName)
        var last=view.findViewById<TextView>(R.id.userLastName)
        var email=view.findViewById<TextView>(R.id.userEmail)
    }
}