package com.ujujzk.mobile.ui.cats

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.ujujzk.mobile.R
import com.ujujzk.mobile.core.BaseAdapter
import com.ujujzk.mobile.core.extension.inflate
import com.ujujzk.mobile.databinding.ItemCatBinding
import com.ujujzk.mobile.model.CatView
import javax.inject.Inject

class CatListAdapter
@Inject constructor()
    : BaseAdapter<CatView, CatListAdapter.CatViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            CatViewHolder(parent.inflate<ItemCatBinding>(R.layout.item_cat))



    override fun onBindViewHolder(holder: CatViewHolder, pos: Int) =
            holder.bind(data[pos])


    override fun addItem(item: CatView) {

    }

    inner class CatViewHolder(private val binding: ItemCatBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cat: CatView) {
            binding.cat = cat
            binding.executePendingBindings()
        }
    }
}