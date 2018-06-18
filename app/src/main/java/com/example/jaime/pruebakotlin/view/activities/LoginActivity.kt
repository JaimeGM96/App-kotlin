package com.example.jaime.pruebakotlin.view.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jaime.pruebakotlin.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        getSupportActionBar()?.hide()

        initialize()
    }

    private fun initialize() {
        btn_login.setOnClickListener {
            checkLogin()
        }

        Picasso.with(this).load(R.mipmap.main_logo).into(iv_logo)
    }

    private fun checkLogin(){
        if ((!et_user_name.text.toString().equals("jaime")) || (!et_password.text.toString().equals("12345"))){
            Toast.makeText(this, "Login o Password no validos", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, UserListActivity::class.java)
            val datosSalida: String = et_user_name.text.toString()
            intent.putExtra("login", datosSalida)
            startActivity(intent)
        }
    }

    companion object {
        fun getCallingIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}
