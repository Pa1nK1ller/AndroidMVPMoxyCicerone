package com.example.androidmvpmoxycicerone.view

import com.example.androidmvpmoxycicerone.model.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface DetailsView : MvpView {
    fun showDetailsUser(detailsUser: GithubUser)
}