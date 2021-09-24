package com.example.androidmvpmoxycicerone.presentation

import com.example.androidmvpmoxycicerone.App
import com.example.androidmvpmoxycicerone.view.DetailsView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class DetailsPresenter:MvpPresenter<DetailsView>() {
    private val detailsUserRepo = App.instance.detailsUserRepo
    private val router: Router = App.instance.router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showDetailsUser(detailsUserRepo.detailsUser)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}