package com.antique_boss.mypage.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.antique_boss.mypage.MyPageComponentProvider
import com.antique_boss.mypage.viewmodel.MyPageViewModel
import com.antique_boss.mypage.R
import javax.inject.Inject

class MyPageFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy { ViewModelProvider(this, viewModelFactory).get(MyPageViewModel::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().applicationContext as MyPageComponentProvider).provideMyPageComponent().inject(this)
        Log.d("MyPageViewModel", "MyPageFragment: $viewModel")
        viewModel.test()
    }
}