package com.example.starwars.providers

import com.example.starwars.activities.BASE_URL
import com.example.starwars.presenters.HeroPresenter
import com.example.workingwithswapilibrary.Factory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HeroProvider(val presenter: HeroPresenter) {
    fun loadingHero(nameHero: String){

        Factory.sharedUrl = BASE_URL
        val router = Factory.shared

        GlobalScope.launch(Dispatchers.Main) {

            val request = withContext(Dispatchers.IO) {
                router.getHeroesByName(nameHero)
            }

        }
    }
}