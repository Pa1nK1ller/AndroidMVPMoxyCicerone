package com.example.androidmvpmoxycicerone.presentation

import com.example.androidmvpmoxycicerone.model.GithubUser
import com.example.androidmvpmoxycicerone.view.UserItemView

class UsersListPresenter : IUserListPresenter {
    val users = mutableListOf<GithubUser>()
    override var itemClickListener: ((UserItemView) -> Unit)? = null
    override fun bindView(view: UserItemView) {
        val user = users[view.pos]
        view.showLogin(user.login)
    }

    override fun getCount(): Int = users.size
}