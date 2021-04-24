package id.rdev.Dim.activity.login

import id.rdev.Dim.model.User

interface LoginView {
    fun onSuccessLogin(user: User?)
    fun onErrorLogin(msg: String?)
}