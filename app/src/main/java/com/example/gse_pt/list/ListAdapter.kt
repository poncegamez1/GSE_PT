package com.example.gse_pt.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gse_pt.databinding.CardViewItemBinding
import com.example.gse_pt.model.Users

class ListAdapter :RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private val userList: ArrayList<Users> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = CardViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun appendItems(newItems: List<Users>){
        userList.clear()
        userList.addAll(newItems)
        notifyDataSetChanged()
    }


    class ListViewHolder(private val binding:CardViewItemBinding) :
            RecyclerView.ViewHolder(binding.root) {

                fun bind(users: Users){
                    binding.idTextView.text = users.id.toString()
                    binding.nameTextView.text = users.name
                    binding.usernmeTextView.text = users.username
                    binding.emailTextView.text = users.email
                    binding.phoneTextView.text = users.phone
                    binding.websiteTextView.text = users.website
                }
            }


}