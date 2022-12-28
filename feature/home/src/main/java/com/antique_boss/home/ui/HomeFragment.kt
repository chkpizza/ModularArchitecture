package com.antique_boss.home.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.antique_boss.home.HomeComponentProvider
import com.antique_boss.home.viewmodel.HomeViewModel
import com.antique_boss.home.R
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by navGraphViewModels<HomeViewModel>(R.id.home_nav_graph) { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().applicationContext as HomeComponentProvider).provideHomeComponent().inject(this)

        Log.d("HomeViewModel", "HomeFragment: $viewModel")
        viewModel.test()

        view.findViewById<Button>(R.id.inner_transition_test).setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment()
            findNavController().navigate(action)
        }
    }


    private fun getDpi() {
        val density = resources.displayMetrics.density
        val result = when {
            density >= 4.0 -> "xxxhdpi"
            density >= 3.0 -> "xxhdpi"
            density >= 2.0 -> "xhdpi"
            density >= 1.5 -> "hdpi"
            density >= 1.0 -> "mdpi"
            else -> "ldpi"
        }
        Log.d("DPI", result)
    }
}