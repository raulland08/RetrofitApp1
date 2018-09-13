package com.raulpineres.retrofitapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getResult()
    }

    private fun getResult(){
        val apiService = GithubApiService.create()
        val repository = SearchRepository(apiService)
        repository.searchUsers("Lagos", "Java")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    Log.e("JSON ----->",result.toString())
                    Toast.makeText(this, "There are ${result.items.size} Java developers in Lagos", Toast.LENGTH_LONG).show()
                },{error ->
                    error.printStackTrace()
                })
    }
}
