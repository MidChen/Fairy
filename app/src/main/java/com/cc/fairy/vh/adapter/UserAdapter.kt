package com.cc.fairy.vh.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cc.fairy.database.entity.User
import com.cc.fairy.databinding.RecyclerviewUserBinding
import com.cc.fairy.vh.ViewHolder

class UserAdapter(private val context: Context): RecyclerView.Adapter<ViewHolder>() {

    private val users = ArrayList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerviewUserBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val vb = holder.vb as RecyclerviewUserBinding
        vb.id.text = users[position].id.toString()
        vb.username.text = users[position].username
        vb.datetime.text = users[position].datetime
    }

    override fun getItemCount(): Int = users.size

    fun insert(users: List<User>) {
        this.users.clear()
        this.users.addAll(users)
        notifyItemInserted(itemCount)
    }

}