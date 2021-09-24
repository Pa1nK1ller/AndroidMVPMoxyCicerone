package com.example.androidmvpmoxycicerone

import com.example.androidmvpmoxycicerone.screens.IScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(private val router: Router, val screens: IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.usersScreen())
    }

    fun backPressed() {
        router.exit()
    }
}