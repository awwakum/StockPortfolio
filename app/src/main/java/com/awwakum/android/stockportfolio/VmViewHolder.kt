package com.awwakum.android.stockportfolio

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.awwakum.android.stockportfolio.models.Stock


class VmViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(part: Stock, clickListener: (Stock) -> Unit) {
        itemView.setOnClickListener { clickListener(part)}
    }
}