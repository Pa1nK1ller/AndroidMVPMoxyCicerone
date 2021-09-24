package com.example.androidmvpmoxycicerone.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidmvpmoxycicerone.App
import com.example.androidmvpmoxycicerone.databinding.FragmentUsersBinding
import com.example.androidmvpmoxycicerone.model.GithubUsersRepo
import com.example.androidmvpmoxycicerone.presentation.UsersPresenter
import com.example.androidmvpmoxycicerone.screens.AndroidScreens
import com.example.androidmvpmoxycicerone.view.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    private var vb: FragmentUsersBinding? = null

    private val presenter by moxyPresenter {
        UsersPresenter(
            GithubUsersRepo(),
            App.instance.router,
            AndroidScreens()
        )
    }

    private val adapter by lazy { UsersRVAdapter(presenter.usersListPresenter) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUsersBinding.inflate(inflater, container, false).also {
            vb = it
        }.root
    }

    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(requireContext())
        vb?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun backPressed(): Boolean {
        return presenter.backPressed()
    }

    companion object {
        fun newInstance() = UsersFragment()
    }
}