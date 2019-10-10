package com.example.starwars.activities

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import com.example.starwars.presenters.AllHeroesPresenter
import com.example.starwars.R
import com.example.starwars.views.AllHeroesView
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

const val BASE_URL = "https://swapi.co/api/"

class MainActivity : MvpAppCompatActivity(), AllHeroesView {

    @InjectPresenter
    lateinit var allHeroesPresenter: AllHeroesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        allHeroesPresenter.loadHeroes()

//        etHeroSearch.addTextChangedListener(object: TextWatcher{
//            override fun afterTextChanged(s: Editable?) {}
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//
//            }

//        })

    }


    override fun showError(textResource : Int) {
        tvHeroesNoItems.text = getString(textResource)
    }

    override fun setupEmptyList() {
        etHeroSearch.visibility = View.GONE
        gvAllHeroes.visibility = View.GONE
        tvHeroesNoItems.visibility = View.VISIBLE
    }

    override fun setupHeroes(heroesList: List<String>) {
        gvAllHeroes.visibility = View.VISIBLE
        tvHeroesNoItems.visibility = View.GONE

        val adapter = ArrayAdapter(this@MainActivity, R.layout.item, R.id.tvHero, heroesList)
        gvAllHeroes.adapter = adapter
    }

    override fun startLoading() {
        etHeroSearch.visibility = View.GONE
        gvAllHeroes.visibility = View.GONE
        tvHeroesNoItems.visibility = View.GONE
        pbAllHeroes.visibility = View.VISIBLE
    }

    override fun endLoading() {
        etHeroSearch.visibility = View.VISIBLE
        pbAllHeroes.visibility = View.GONE
    }

    override fun openHero() {
        startActivity(Intent(applicationContext, HeroActivity::class.java))
    }


}
