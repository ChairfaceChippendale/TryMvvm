package com.ujujzk.mobile.ui.cats

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.ujujzk.domain.model.Cat
import com.ujujzk.mobile.R
import com.ujujzk.mobile.core.extension.inflate
import com.ujujzk.mobile.databinding.ItemCatBinding
import com.ujujzk.mobile.model.CatView
import javax.inject.Inject
import kotlin.properties.Delegates

class CatListAdapter
@Inject constructor()
    : RecyclerView.Adapter<CatListAdapter.CatViewHolder>() {

    internal var cats: List<CatView> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            CatViewHolder(parent.inflate<ItemCatBinding>(R.layout.item_cat))

    override fun getItemCount() =
            cats.size

    override fun onBindViewHolder(holder: CatViewHolder, pos: Int) =
            holder.bind(cats[pos])


    inner class CatViewHolder(private val binding: ItemCatBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cat: CatView) {
            binding.cat = cat
            binding.executePendingBindings()
        }
    }
}