package com.wong.kotlinmvp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import kotlinx.android.extensions.CacheImplementation
import kotlinx.android.extensions.ContainerOptions
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.text_view_item.*

@ContainerOptions(CacheImplementation.SPARSE_ARRAY)
class MainActivity : AppCompatActivity(),MainActivityMVP.View{
    var presenter:MainActivityMVP.Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar.visibility = View.GONE
        presenter = MainActivityPresenter(this,MainActivityModel())
        buttonLogin.setOnClickListener { presenter?.let { it.validateCredentials(editTextUserName.text.toString(),editTextTextPassword.text.toString()) } }

    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun setUserNameError() {
        editTextUserName.error = getString(R.string.username_error)
    }

    override fun setPasswordError() {
        editTextTextPassword.error = getString(R.string.password_error)
    }

    /**
     * open Home page
     */
    override fun navigateToHome() {
        val intent = Intent()
        intent.putExtra("user",User(editTextUserName.text.toString(),editTextTextPassword.text.toString()))
        intent.setClass(this,HomeActivity::class.java)
        startActivity(intent)
    }

}