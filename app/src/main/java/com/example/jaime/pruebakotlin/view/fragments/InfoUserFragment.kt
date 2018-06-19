package com.example.jaime.pruebakotlin.view.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jaime.pruebakotlin.model.BorderedCircleTransform
import com.example.jaime.pruebakotlin.model.Result
import com.example.jaime.pruebakotlin.R
import com.squareup.picasso.Picasso

class InfoUserFragment : Fragment() {

    internal lateinit var context: Context

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_info_user, container, false)

        mostrarDatos()
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.context = context!!
    }

    private fun mostrarDatos(){
        val bundle = arguments.getSerializable("object")
        val user: Result = bundle as Result
        this.name.text = user.name.first
        lastName.text = user.name.last
        email.text = user.email
        userName.text = user.login.username
        phone.text = user.phone
        Picasso.with(context).load(user.picture.large).transform(BorderedCircleTransform(0, Color.BLACK)).resize(400,400).into(userImage)
    }

    companion object {
        fun newInstance(user:Result): InfoUserFragment {
            val fragment = InfoUserFragment()
            val bundle = Bundle()
            bundle.putSerializable("object", user)
            fragment.arguments = bundle
            return fragment
        }
    }
}
