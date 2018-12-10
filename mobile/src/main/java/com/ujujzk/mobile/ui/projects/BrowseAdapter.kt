package com.ujujzk.mobile.ui.projects

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ujujzk.mobile.databinding.ItemProjectBinding
import com.ujujzk.mobile.model.ProjectView

class BrowseAdapter : RecyclerView.Adapter<BrowseAdapter.ViewHolder>(){

    var projects: List<ProjectView> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int = projects.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.project = projects[position]
    }

    inner class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val binding: ItemProjectBinding

        init {
            binding = ItemProjectBinding.bind(view)
        }

    }
}