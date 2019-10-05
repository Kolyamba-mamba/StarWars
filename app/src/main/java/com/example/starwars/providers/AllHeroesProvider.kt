package com.example.starwars.providers

import com.example.starwars.activities.BASE_URL
import com.example.starwars.presenters.AllHeroesPresenter
import com.example.workingwithswapilibrary.Factory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AllHeroesProvider(var presenter: AllHeroesPresenter) {
    fun loadingHeroes(){

        Factory.sharedUrl = BASE_URL
        val router = Factory.shared

            GlobalScope.launch(Dispatchers.Main) {

                val request = withContext(Dispatchers.IO) {
                    router.getAllHeroes().results
                }

                val heroes = request.map { it.name }

                presenter.heroesLoaded(heroesList = heroes)
        }
    }
}