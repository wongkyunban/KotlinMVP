package com.wong.kotlinmvp

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.custom_view.view.*

@SuppressLint("UseCompatLoadingForDrawables")
class CustomView @JvmOverloads constructor(context: Context, attrs: AttributeSet?=null, defStyleAttr:Int = 0) : LinearLayout(context,attrs,defStyleAttr) {
    init{
        LayoutInflater.from(context).inflate(R.layout.custom_view,this,true)
        itemTitle.text = "Hello world &&"
        println("@@${itemTitle.text}")
        itemImage.setImageDrawable(resources.getDrawable(R.drawable.ic_launcher_background,null))
    }
}