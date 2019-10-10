package com.example.starwars.presenters

import com.example.starwars.views.HeroView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class HeroPresenter: MvpPresenter<HeroView>() {
    fun loadHero(){
        viewState.startLoading()
    }
}