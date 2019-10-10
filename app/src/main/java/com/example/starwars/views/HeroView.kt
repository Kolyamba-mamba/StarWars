package com.example.starwars.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(value = AddToEndSingleStrategy::class)
interface HeroView: MvpView {
    fun showError(textResource : Int)
    fun setupEmpty()
    fun setupHero()
    fun startLoading()
    fun endLoading()
}