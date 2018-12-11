package com.ujujzk.mobile.ui.cats

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ujujzk.mobile.R
import com.ujujzk.mobile.databinding.FragmentCatsBinding
import com.ujujzk.mobile.model.CatView
import com.ujujzk.mobile.model.wrapper.DataState
import com.ujujzk.mobile.model.wrapper.DataWrapper
import com.ujujzk.mobile.ui.BaseFragment

import kotlinx.android.synthetic.main.fragment_cats.*

class CatsFragment: BaseFragment() {


    val catListAdapter = CatListAdapter()

    private lateinit var binding: FragmentCatsBinding
    private lateinit var viewModel: CatsVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cats, container, false)
//        appComponent.inject(this)

        viewModel = ViewModelProviders.of(this).get(CatsVM::class.java)
        viewModel.cats.observe(this, Observer<DataWrapper<List<CatView>>> {
            when(it?.status) {
                DataState.SUCCESS -> {}
                DataState.ERROR -> {}
                DataState.LOADING -> {}
            }
        })

        cat_list.layoutManager = LinearLayoutManager(context)
        cat_list.adapter = catListAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCats()
    }
}