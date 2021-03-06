package com.example.jaime.pruebakotlin.view.adapters

import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.jaime.pruebakotlin.model.schoolAPI.SchoolResult
import com.example.jaime.pruebakotlin.R
import java.util.*

/**
 * Created by jaime on 19/3/18.
 */

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {
    private var list: List<SchoolResult> = ArrayList()
    private lateinit var context: Context
    private lateinit var fragmentManager: FragmentManager

    fun Adaptador(list: List<SchoolResult>, context: Context, fragmentManager: FragmentManager){
        this.list = list
        this.context = context
        this.fragmentManager = fragmentManager
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list.get(position)
        holder.bind(item, context, this.fragmentManager)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_usuarios_list, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre = view.findViewById(R.id.userName) as TextView
        val apellido = view.findViewById(R.id.userLastname) as TextView
        val imagen = view.findViewById(R.id.userImage) as ImageView
        lateinit var fragmentManager: FragmentManager

        fun bind(user: SchoolResult, context: Context, fragmentManager: FragmentManager){
            nombre.text = user.student.name
            apellido.text = user.student.lastName
            //Picasso.with(context).load(user.picture.large).transform(BorderedCircleTransform(0, Color.BLACK)).into(imagen)
            this.fragmentManager = fragmentManager
            //itemView.setOnClickListener(View.OnClickListener { showInfoUserFragment(user, context) })
        }

        /*private fun showInfoUserFragment(user:SchoolResult, context: Context){
            this.fragmentManager.beginTransaction()
                    .replace(R.id.userDetail, InfoUserFragment.newInstance(user), "infoUser")
                    .addToBackStack(null)
                    .commit()
        }*/
    }
}