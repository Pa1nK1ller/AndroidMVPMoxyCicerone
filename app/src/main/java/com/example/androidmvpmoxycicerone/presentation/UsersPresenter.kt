package com.example.androidmvpmoxycicerone.presentation

import com.example.androidmvpmoxycicerone.App
import com.example.androidmvpmoxycicerone.model.GithubUsersRepo
import com.example.androidmvpmoxycicerone.screens.IScreens
import com.example.androidmvpmoxycicerone.view.ui.UsersView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepo: GithubUsersRepo,
    private val router: Router,
    private val screens: IScreens
) : MvpPresenter<UsersView>() {

    val usersListPresenter = UsersListPresenter()
    private val detailsUserRepo = App.instance.detailsUserRepo

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            val detailsUser = usersListPresenter.users[itemView.pos]
            detailsUserRepo.detailsUser = detailsUser

            router.navigateTo(screens.detailsScreen())
        }
    }

    private fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}