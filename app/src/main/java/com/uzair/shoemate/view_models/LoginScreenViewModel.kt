package com.uzair.shoemate.view_models

import androidx.lifecycle.ViewModel
import com.uzair.shoemate.data_source.User

class LoginScreenViewModel : ViewModel() {
    fun isValidaUser(user: User): Boolean {
        val userName = user.name ?: ""
        val password = user.password ?: ""

        return !(userName.isBlank() || password.isBlank())
    }
}