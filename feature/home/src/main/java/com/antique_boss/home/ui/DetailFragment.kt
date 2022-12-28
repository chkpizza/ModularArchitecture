package com.antique_boss.home.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navGraphViewModels
import com.antique_boss.home.HomeComponentProvider
import com.antique_boss.home.viewmodel.HomeViewModel
import com.antique_boss.home.R
import javax.inject.Inject
import javax.inject.Named

class DetailFragment : Fragment() {
    @Inject
    @Named("HomeViewModelFactory")
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by navGraphViewModels<HomeViewModel>(R.id.home_nav_graph) { viewModelFactory }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().applicationContext as HomeComponentProvider).provideHomeComponent().inject(this)
        Log.d("HomeViewModel", "DetailFragment: $viewModel")
        viewModel.test()
    }
}