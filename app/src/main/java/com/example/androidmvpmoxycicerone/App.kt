package com.example.androidmvpmoxycicerone

import android.app.Application
import com.example.androidmvpmoxycicerone.model.DetailsUserRepo
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class App : Application() {

    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }
    val navigationHolder get() = cicerone.getNavigatorHolder()
    val router get() = cicerone.router

    val detailsUserRepo = DetailsUserRepo()

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: App
    }
}