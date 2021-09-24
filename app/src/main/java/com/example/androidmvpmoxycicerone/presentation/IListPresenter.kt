package com.example.androidmvpmoxycicerone.presentation

import com.example.androidmvpmoxycicerone.view.IItemView
import com.example.androidmvpmoxycicerone.view.UserItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount():Int
}
interface IUserListPresenter : IListPresenter<UserItemView>