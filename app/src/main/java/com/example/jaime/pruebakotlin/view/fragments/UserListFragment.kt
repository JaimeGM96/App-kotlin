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
import com.example.jaime.pruebakotlin.Modelo.ApiResponse
import com.example.jaime.pruebakotlin.Modelo.Result
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
        val apiInterface = apiClient.getClient()
        val call = apiInterface.getUsers("20")
        call?.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: retrofit2.Response<ApiResponse>) {
                if (response != null) {
                    var datos: List<Result> = response.body()!!.results
                    setUpRecyclerView(datos)
                }
            }
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
            }
        })
        return view
    }

    fun setUpRecyclerView(datos: List<Result>){
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
        fun onUserSelected(user: Result)
    }
}
