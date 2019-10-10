package com.example.starwars.presenters

import com.example.starwars.R
import com.example.starwars.providers.AllHeroesProvider
import com.example.starwars.views.AllHeroesView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class AllHeroesPresenter: MvpPresenter<AllHeroesView>() {
     fun loadHeroes() {
        viewState.startLoading()
        AllHeroesProvider(presenter = this).loadingHeroes()
    }

    fun heroesLoaded(heroesList: List<String>) {
        viewState.endLoading()
        if (heroesList.isEmpty()) {
            viewState.setupEmptyList()
            viewState.showError(textResource = R.string.heroesNoItems)
        } else {
            viewState.setupHeroes(heroesList = heroesList)

        }
    }
}