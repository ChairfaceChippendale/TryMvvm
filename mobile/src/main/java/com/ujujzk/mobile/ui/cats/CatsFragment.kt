package com.ujujzk.mobile.ui.cats

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ujujzk.mobile.R
import com.ujujzk.mobile.databinding.FragmentCatsBinding

class CatsFragment: Fragment() {

    lateinit var binding: FragmentCatsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cats, container, false)


        return binding.root
    }
}