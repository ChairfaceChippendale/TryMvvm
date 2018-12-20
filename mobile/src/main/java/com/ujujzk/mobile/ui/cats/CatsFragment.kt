package com.ujujzk.mobile.ui.cats

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ujujzk.mobile.R
import com.ujujzk.mobile.databinding.FragmentCatsBinding
import com.ujujzk.mobile.ui.BaseFragment


class CatsFragment : BaseFragment() {

    private lateinit var binding: FragmentCatsBinding
    private lateinit var viewModel: CatsVM

    companion object {
        fun inst(): CatsFragment {
            return CatsFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CatsVM::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cats, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.executePendingBindings()
        viewModel.getCats()
    }
}