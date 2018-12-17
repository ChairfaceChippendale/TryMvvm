package com.ujujzk.mobile.core

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView

import javax.inject.Inject
import kotlin.properties.Delegates

abstract class BaseAdapter <T, VH : RecyclerView.ViewHolder>
    : RecyclerView.Adapter<VH>() {

    internal var data: List<T> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun getItemCount() =
            data.size


}