package com.example.exam_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    lateinit var recyclerView: RecyclerView
    lateinit var iv_ad: ImageView
    lateinit var list: ArrayList<Cards>
    lateinit var adapter: CardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }
    fun initViews(){
        iv_ad = findViewById(R.id.add_cards)
        iv_ad.setOnClickListener { openDetailActivity() }

        recyclerView = findViewById(R.id.recyclerView)
        list = ArrayList()
        recyclerView.layoutManager = LinearLayoutManager(this)
        workWithRetrofit()
    }

    fun workWithRetrofit(){
        ApiClient.apiService.getAllCards().enqueue(object: Callback<ArrayList<Cards>> {
            override fun onResponse(
                call: Call<ArrayList<Cards>>,
                response: Response<ArrayList<Cards>>
            ) {
                if (response.body() != null)
                    list.addAll(response.body()!!)
                adapter = CardAdapter(list)
                recyclerView.adapter = adapter
                Logger.d("@@@",response.body().toString())
            }

            override fun onFailure(call: Call<ArrayList<Cards>>, t: Throwable) {
                Logger.e("@@@","Failure")
            }

        })
    }

    fun openDetailActivity(){
        val intent: Intent = Intent(this,DetailActivity::class.java)
        startActivity(intent)
    }


}