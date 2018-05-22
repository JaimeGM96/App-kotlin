package com.example.jaime.pruebakotlin.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.example.jaime.pruebakotlin.R

class LoginActivity : AppCompatActivity() {
    @BindView(R.id.btn) lateinit var btn: Button
    @BindView(R.id.login) lateinit var login: EditText
    @BindView(R.id.password) lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        getSupportActionBar()?.hide()
        ButterKnife.bind(this)
        btn.setOnClickListener { verificar() }
    }

    private fun verificar(){
        if ((!login.text.toString().equals("jaime")) || (!password.text.toString().equals("12345"))){
            Toast.makeText(this, "Login o Password no validos", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, ShowUsersActivity::class.java)
            val datosSalida: String = login.text.toString()
            intent.putExtra("login", datosSalida)
            startActivity(intent)
        }
    }
}
