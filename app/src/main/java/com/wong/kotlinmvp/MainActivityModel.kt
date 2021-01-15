package com.wong.kotlinmvp

class MainActivityModel:MainActivityMVP.Model {
    override fun login(userName: String, password: String, listener: (Boolean) -> Unit) {
        when {
            password == "123456" && userName == "jukling" -> {
                listener(true)
            }
            else -> {
                listener(false)
            }
        }
    }
}