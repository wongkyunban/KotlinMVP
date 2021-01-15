package com.wong.kotlinmvp

class MainActivityPresenter(private val view:MainActivityMVP.View, private val model:MainActivityMVP.Model):MainActivityMVP.Presenter {
    override fun validateCredentials(userName: String, password: String) {
        view.showProgress()
        var flag:Boolean = true
        if(userName.isEmpty()){
            view.setUserNameError()
            flag = false
        }
        if(password.length < 6){
            view.setPasswordError()
            flag = false
        }
        if(flag){
            model.login(userName,password){
                if(it){
                    view.navigateToHome()
                }else{
                    view.setUserNameError()
                    view.setPasswordError()
                }
            }
        }
        view.hideProgress()

    }
}