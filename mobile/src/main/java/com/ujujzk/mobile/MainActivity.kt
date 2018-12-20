package com.ujujzk.mobile


import android.databinding.DataBindingUtil
import android.os.Bundle
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

        gamesCount(20, 3, 6, 85)

    }

    override fun progress(progress: Progress) {
        binding.progress.progress = progress
    }

//    fun gamesCount(r: Int, d: Int, m: Int, n: Int): Int {
//
//var b=n
//var p=r
//var c=0
//while(b>=p){b-=p
//p-=d
//if(p<m)p=m
//c++}
//return c
//    }

    fun gamesCount(r: Int, d: Int, m: Int, n: Int): Int {

var b=n
var p=r
var c=0
while(b>=p){b-=p
p=if(p>m+d)p-d else m
c++}
return c
    }
}
