package com.example.starwars.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.starwars.R
import com.example.starwars.views.HeroView
import com.example.workingwithswapilibrary.Factory
import kotlinx.android.synthetic.main.activity_hero.*
import kotlinx.android.synthetic.main.item.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HeroActivity : AppCompatActivity(), HeroView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero)

    }

    override fun showError(textResource: Int) {
        tvHeroNoItem.text = getString(textResource)
    }

    override fun setupEmpty() {
        tvHeroName.visibility = View.GONE
        tvHeroBirthYear.visibility = View.GONE
        tvHeroHeight.visibility = View.GONE
        tvHeroGender.visibility = View.GONE
        tvHeroMass.visibility = View.GONE
        tvHeroNoItem.visibility = View.VISIBLE
    }

    override fun setupHero() {
        tvHeroName.visibility = View.VISIBLE
        tvHeroBirthYear.visibility = View.VISIBLE
        tvHeroHeight.visibility = View.VISIBLE
        tvHeroGender.visibility = View.VISIBLE
        tvHeroMass.visibility = View.VISIBLE
        tvHeroNoItem.visibility = View.GONE
    }

    override fun startLoading() {
        tvHeroName.visibility = View.GONE
        tvHeroBirthYear.visibility = View.GONE
        tvHeroHeight.visibility = View.GONE
        tvHeroGender.visibility = View.GONE
        tvHeroMass.visibility = View.GONE
        tvHeroNoItem.visibility = View.GONE
        pbHero.visibility = View.VISIBLE
    }

    override fun endLoading() {
        pbHero.visibility = View.GONE
    }
}
