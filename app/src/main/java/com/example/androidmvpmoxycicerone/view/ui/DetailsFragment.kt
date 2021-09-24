package com.example.androidmvpmoxycicerone.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidmvpmoxycicerone.databinding.FragmentDetailsBinding
import com.example.androidmvpmoxycicerone.model.GithubUser
import com.example.androidmvpmoxycicerone.presentation.DetailsPresenter
import com.example.androidmvpmoxycicerone.view.BackButtonListener
import com.example.androidmvpmoxycicerone.view.DetailsView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class DetailsFragment : MvpAppCompatFragment(), DetailsView,
    BackButtonListener {

    private val presenter by moxyPresenter { DetailsPresenter() }

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun showDetailsUser(detailsUser: GithubUser) {
        binding.tvLogin.text = detailsUser.login

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun backPressed(): Boolean {
        return presenter.backPressed()
    }

    companion object {
        fun newInstance() = DetailsFragment()
    }
}