package com.example.jaime.pruebakotlin.view.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jaime.pruebakotlin.view.adapters.UserListAdapter
import com.example.jaime.pruebakotlin.model.ApiResponseSchool
import com.example.jaime.pruebakotlin.model.SchoolResult
import com.example.jaime.pruebakotlin.R
import com.example.jaime.pruebakotlin.Rest.ApiClient
import retrofit2.Call
import retrofit2.Callback

class UserListFragment : Fragment() {
    private val mAdapter : UserListAdapter = UserListAdapter()
    lateinit var mRecyclerView: RecyclerView
    internal lateinit var context: Context
    private lateinit var listener: OnUserSelected

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_users, container, false)
        mRecyclerView = view.findViewById<RecyclerView>(R.id.rvUserList) as RecyclerView
        val apiClient = ApiClient()
        val apiInterface = apiClient.getStundent()
        val call = apiInterface.startClass()
        call?.enqueue(object : Callback<ApiResponseSchool> {
            override fun onResponse(call: Call<ApiResponseSchool>, response: retrofit2.Response<ApiResponseSchool>) {
                if (response != null) {
                    var datos: List<SchoolResult> = response.body()!!.results
                    println(response)
                    println(response.body())
                    println("asdasdasdasda")
                    println(datos)
                    setUpRecyclerView(datos)
                    println(response)
                    println(response.body())
                    println("asdasdasdasda")
                    println(datos)
                }
            }
            override fun onFailure(call: Call<ApiResponseSchool>, t: Throwable) {
                println("asdasdasdasdasdasdasdasdasdasdgfgafgfa")
            }
        })
        return view
    }

    fun setUpRecyclerView(datos: List<SchoolResult>){
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter.Adaptador(datos, context, fragmentManager)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.adapter = mAdapter
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.context = context!!
        if (context is OnUserSelected) {
            listener = context
        } else {
            throw ClassCastException(context.toString() + " must implement OnRageComicSelected.")
        }
    }

    companion object {
        fun newInstance(): UserListFragment {
            val fragment = UserListFragment()
            return fragment
        }
    }

    interface OnUserSelected {
        fun onUserSelected(user: SchoolResult)
    }
}
