package com.wong.kotlinmvp

interface MainActivityMVP {
    /**
     * View interface
     */
    interface View{
        fun showProgress()
        fun hideProgress()
        fun setUserNameError()
        fun setPasswordError()
        fun navigateToHome()
    }

    /**
     * Model interface
     */
    interface Model{
        fun login(userName:String,password:String,listener:(Boolean)->Unit)
    }

    /**
     * Presenter interface
     */
    interface Presenter{
        fun validateCredentials(userName:String,password:String)
    }

}