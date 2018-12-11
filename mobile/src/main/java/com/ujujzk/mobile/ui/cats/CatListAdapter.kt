package com.ujujzk.mobile.ui.cats

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.ujujzk.mobile.R
import com.ujujzk.mobile.core.extension.inflate
import com.ujujzk.mobile.databinding.ItemCatBinding
import com.ujujzk.mobile.model.CatView
import kotlin.properties.Delegates

class CatListAdapter : RecyclerView.Adapter<CatListAdapter.CatViewHolder>() {

    internal var cats: List<CatView> by Delegates.observable(emptyList()) {
        _, _, _ -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            CatViewHolder (parent.inflate(R.layout.item_cat))

    override fun getItemCount() = cats.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.binding?.cat = cats[position]
    }


    inner class CatViewHolder (view: View):RecyclerView.ViewHolder(view) {
        val binding = DataBindingUtil.bind<ItemCatBinding>(view)
    }
}