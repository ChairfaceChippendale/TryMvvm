package com.ujujzk.mobile.ui.projects

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.ujujzk.mobile.R
import com.ujujzk.mobile.databinding.ActivityMainBinding
import com.ujujzk.mobile.injection.ViewModelFactory
import com.ujujzk.mobile.model.ProjectView
import com.ujujzk.mobile.model.wrapper.DataWrapper
import com.ujujzk.mobile.model.wrapper.DataState
import dagger.android.AndroidInjection

import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class BrowseActivity : AppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: BrowseProjectsVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        AndroidInjection.inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(BrowseProjectsVM::class.java)

        setupProjectList()
    }

    override fun onStart() {
        super.onStart()
        viewModel.getLifeData().observe(this, Observer<DataWrapper<List<ProjectView>>> {
            it?.let {
                when (it.status) {
                    DataState.SUCCESS -> {

                    }
                    DataState.LOADING -> {

                    }
                    DataState.ERROR -> {

                    }
                }
            }
        })
    }

    private fun setupProjectList() {
        project_list.layoutManager = LinearLayoutManager(this)
        project_list.adapter = BrowseAdapter()
    }
}