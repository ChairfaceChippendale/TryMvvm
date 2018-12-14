package com.ujujzk.mobile

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.IBinder
import com.ujujzk.mobile.databinding.ActivityMainBinding
import com.ujujzk.mobile.model.Progress
import com.ujujzk.mobile.ui.BaseActivity
import com.ujujzk.mobile.ui.cats.CatsFragment

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        replaceFragment(CatsFragment.inst(), R.id.container)

    }

    override fun progress(progress: Progress) {
        binding.progress.progress = progress
    }
}
