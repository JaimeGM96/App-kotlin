package com.example.jaime.pruebakotlin.view.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.jaime.pruebakotlin.view.fragments.UserListFragment
import com.example.jaime.pruebakotlin.model.schoolAPI.SchoolResult
import com.example.jaime.pruebakotlin.R


class UserListActivity : AppCompatActivity(), UserListFragment.OnUserSelected {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_datos)

        if (savedInstanceState == null){
            var fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().add(R.id.users_container, UserListFragment.newInstance(), "usersList").commit()
        }
    }

    override fun onUserSelected(user: SchoolResult) {
        Toast.makeText(this, "Objeto seleccionado",
                Toast.LENGTH_SHORT).show()
    }
}
