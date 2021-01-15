package com.wong.kotlinmvp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.custom_view.view.*
import kotlinx.android.synthetic.main.text_view_item.*

class HomeActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val user = intent.getParcelableExtra<User>("user")
        customView.itemTitle.text = "Hello ${user?.userName}"
        initRv()
    }
    private fun initRv():Unit{
        val list:List<String> = listOf("A","B","C","D")
        val adapter: RecyclerView.Adapter<TextViewHolder> = object:
            RecyclerView.Adapter<TextViewHolder>(){
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
                return TextViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.text_view_item,parent,false))
            }

            override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
                holder.bind(list[position])
            }

            override fun getItemCount(): Int {
                return list.size
            }

        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private class TextViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bind(title: String) {
            textViewTitle.text = title
        }
    }
}