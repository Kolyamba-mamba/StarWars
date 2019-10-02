package com.example.starwars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val BASE_URL = "https://swapi.co/api/"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val a = listOf<String>("Arra", "Kolya", "Senya", "Horvat")

//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, a)

//        gridView.adapter = adapter

//        gridView.onItemClickListener =
//            AdapterView.OnItemClickListener { parent, view, position, id ->
//                val selectedItem = parent?.getItemAtPosition(position).toString()
//
//                tvItem.text = "GridView item clicked : $selectedItem \nAt index position : $position"
//            }

        com.example.workingwithswapilibrary.Factory.sharedUrl = BASE_URL
        val router = com.example.workingwithswapilibrary.Factory.shared

        CoroutineScope(Dispatchers.IO).launch {
            var req1 = router.getAllHeroes()
            var req2 = router.getHeroesByName("Luke")
            println(req1)
            println(req2)
        }

    }
}
