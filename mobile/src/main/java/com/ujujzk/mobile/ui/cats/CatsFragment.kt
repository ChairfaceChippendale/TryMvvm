package com.ujujzk.mobile.ui.cats

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ujujzk.domain.model.Cat
import com.ujujzk.mobile.R
import com.ujujzk.mobile.databinding.FragmentCatsBinding
import com.ujujzk.mobile.model.CatView
import com.ujujzk.mobile.model.Progress
import com.ujujzk.mobile.model.wrapper.DataState
import com.ujujzk.mobile.model.wrapper.DataWrapper
import com.ujujzk.mobile.ui.BaseFragment

import kotlinx.android.synthetic.main.fragment_cats.*
import javax.inject.Inject

class CatsFragment : BaseFragment() {

    @Inject
    lateinit var catListAdapter: CatListAdapter

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


        viewModel.cats.observe(this, Observer<DataWrapper<List<CatView>>> {
            when (it?.status) {
                DataState.SUCCESS -> {
                    progress(Progress.hide())
                    catListAdapter.cats = it.data ?: emptyList<CatView>()
                }
                DataState.ERROR -> {
                    progress(Progress.hide())
                }
                DataState.LOADING -> progress(Progress.show("Loading..."))
            }
        })

        cat_list.layoutManager = LinearLayoutManager(context)
        cat_list.adapter = catListAdapter
        viewModel.getCats()
    }
}