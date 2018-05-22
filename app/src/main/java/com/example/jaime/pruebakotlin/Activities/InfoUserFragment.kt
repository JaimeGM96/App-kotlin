package com.example.jaime.pruebakotlin.Activities

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.jaime.pruebakotlin.Modelo.BorderedCircleTransform
import com.example.jaime.pruebakotlin.Modelo.Result
import com.example.jaime.pruebakotlin.R
import com.squareup.picasso.Picasso

class InfoUserFragment : Fragment() {
    internal lateinit var context: Context
    lateinit var image: ImageView
    lateinit var name: TextView
    lateinit var lastName: TextView
    lateinit var email: TextView
    lateinit var userName: TextView
    lateinit var phone: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_info_user, container, false)
        image = view.findViewById<ImageView>(R.id.userImage) as ImageView
        name = view.findViewById<TextView>(R.id.name) as TextView
        lastName = view.findViewById<TextView>(R.id.lastName) as TextView
        email = view.findViewById<TextView>(R.id.email) as TextView
        userName = view.findViewById<TextView>(R.id.userName) as TextView
        phone = view.findViewById<TextView>(R.id.phone) as TextView
        mostrarDatos()
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.context = context!!
    }

    override fun onDetach() {
        super.onDetach()
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

    private fun mostrarDatos(){
        val bundle = arguments.getSerializable("object")
        val user: Result = bundle as Result
        this.name.text = user.name.first
        lastName.text = user.name.last
        email.text = user.email
        userName.text = user.login.username
        phone.text = user.phone
        Picasso.with(context).load(user.picture.large).transform(BorderedCircleTransform(0, Color.BLACK)).resize(400,400).into(image)
    }
}
