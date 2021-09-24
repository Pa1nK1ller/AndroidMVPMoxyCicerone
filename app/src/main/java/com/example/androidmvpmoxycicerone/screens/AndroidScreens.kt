package com.example.androidmvpmoxycicerone.screens

import com.example.androidmvpmoxycicerone.view.ui.DetailsFragment
import com.example.androidmvpmoxycicerone.view.ui.UsersFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen


class AndroidScreens : IScreens {

    override fun usersScreen(): Screen = FragmentScreen { UsersFragment.newInstance() }
    override fun detailsScreen(): Screen = FragmentScreen { DetailsFragment.newInstance() }
}