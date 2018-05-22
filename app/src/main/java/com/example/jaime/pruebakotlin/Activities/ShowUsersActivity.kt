package com.example.jaime.pruebakotlin.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.jaime.pruebakotlin.Modelo.Result
import com.example.jaime.pruebakotlin.R


class ShowUsersActivity : AppCompatActivity(), UsersFragment.OnUserSelected {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_datos)

        if (savedInstanceState == null){
            var fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().add(R.id.users_container, UsersFragment.newInstance(), "usersList").commit()
        }
    }

    override fun onUserSelected(user: Result) {
        Toast.makeText(this, "Objeto seleccionado",
                Toast.LENGTH_SHORT).show()
    }
}
