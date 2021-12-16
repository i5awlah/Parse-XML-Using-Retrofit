package com.example.parsexmlusingretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private  val TAG = "MainActivity"
    private  val BASE_URL = "https://howtodoinjava.com/"

    lateinit var btnFetch:Button
    lateinit var tvTitle:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvTitle = findViewById(R.id.tvTitle)
        btnFetch = findViewById(R.id.btnFetch)


        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        val feedAPI = retrofit.create(FeedAPI::class.java)
        val call = feedAPI.feed

        btnFetch.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                call!!.enqueue(object : Callback<RssFeed?> {
                    override fun onResponse(call: Call<RssFeed?>, response: Response<RssFeed?>) {
                        Log.d(TAG, "onResponse: feed: " + response.body().toString())
                        Log.d(TAG, "onResponse: Server Response: $response")
                        Log.d(TAG, "onResponse: Server Response: ${response.body()?.channel?.title}")

                        val items = response.body()!!.channel?.items
                        for (item in items!!) {
                            Log.d(TAG, "title: " + item.title)
                            var text = tvTitle.text.toString()
                            tvTitle.text = text + "\n" + item.title
                        }
                    }

                    override fun onFailure(call: Call<RssFeed?>, t: Throwable) {
                        Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.message)
                        Toast.makeText(this@MainActivity, "An Error Occured", Toast.LENGTH_SHORT).show()
                    }
                })

            }

        })

    }

}