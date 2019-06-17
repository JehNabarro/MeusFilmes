package com.example.nabarro.meusfilmes.ViewModel

import android.arch.lifecycle.ViewModel
import android.text.Editable
import android.text.TextWatcher
import com.example.nabarro.meusfilmes.Model.User
import com.example.nabarro.meusfilmes.`interface`.LoginResultCalBack

class LoginViewModel(private val listener:LoginResultCalBack):ViewModel(){

    private val user:User

    init {
        this.user = User("","")
    }

    val emailTextWatcher:TextWatcher
    get() = object:TextWatcher{
        override fun afterTextChanged(p0: Editable?) {
            user.setUsuario(p0.toString())
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    }


    val senhaTextWatcher:TextWatcher
        get() = object:TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                user.setSenha(p0.toString())

                if(p0?.length == 6 )
                    if(user.isDataValid)
                        listener.onSuccess("Login Sucess")
                    else
                        listener.onError("Erro no login ou senha")
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        }
}