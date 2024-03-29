package com.example.starwars.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(value = AddToEndSingleStrategy::class)
interface AllHeroesView: MvpView {
    fun showError(textResource : Int)
    fun setupEmptyList()
    fun setupHeroes(heroesList: List<String>)
    @StateStrategyType(SkipStrategy::class)
    fun startLoading()
    fun endLoading()
    fun openHero()
}