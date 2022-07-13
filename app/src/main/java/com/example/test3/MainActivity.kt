package com.example.test3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test3.adapter.ProfileAdapter
import com.example.test3.databinding.ActivityMainBinding
import com.example.test3.model.CommonItemsModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var profileAdapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val optionsList = mutableListOf(
            CommonItemsModel(R.drawable.group_one,"edit profile",null,R.drawable.arrow),
            CommonItemsModel(R.drawable.icon_location,"Address",null,R.drawable.arrow),
            CommonItemsModel(R.drawable.notification,"Notifications",null,R.drawable.arrow),
            CommonItemsModel(R.drawable.wallet,"Payment",null,R.drawable.arrow),
            CommonItemsModel(R.drawable.safe,"Security",null,R.drawable.arrow),
            CommonItemsModel(R.drawable.language,"Languages","English(US)",R.drawable.arrow),
            CommonItemsModel(R.drawable.icon_eye,"Dark Mode",null,R.drawable.switcher),
            CommonItemsModel(R.drawable.icon_lock,"Privacy Policy",null,R.drawable.arrow),
            CommonItemsModel(R.drawable.info,"Help Center",null,R.drawable.arrow),
            CommonItemsModel(R.drawable.people,"Invite",null,R.drawable.arrow),
            CommonItemsModel(R.drawable.logout,"LogOut",null,null),
        )

        setAdapter(optionsList)

    }

    private fun setAdapter(data:MutableList<CommonItemsModel>){
        profileAdapter = ProfileAdapter()
        binding.profileRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = profileAdapter
        }
        profileAdapter.setData(data)
    }
}