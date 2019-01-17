package com.awwakum.android.stockportfolio

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.awwakum.android.stockportfolio.models.Stock
import timber.log.Timber

class StockListAdapter : RecyclerView.Adapter<VmViewHolder>(), IBaseListAdapter<Stock> {

    private var mItems = ArrayList<Stock>()
    override fun getItemCount() = mItems.size

    override fun getItemViewType(position: Int) = mItems[position].layoutId

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VmViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val viewDataBinding = DataBindingUtil.inflate<ViewDataBinding>(inflater!!, viewType, parent, false)

        return VmViewHolder(viewDataBinding)
    }

    override fun onBindViewHolder(holder: VmViewHolder, position: Int) {
        Timber.d("BR.stock: %s, mItems[position]: %s", BR.stock, mItems[position])
        holder.binding.setVariable(BR.stock, mItems[position])
        holder.binding.executePendingBindings()
    }

    override fun add(newItem: Stock) {
        mItems.add(newItem)
        notifyItemInserted(mItems.lastIndex)
    }

    override fun add(newItems: ArrayList<Stock>?) {
        val oldSize = mItems.size
        mItems.addAll(newItems!!)
        notifyItemRangeInserted(oldSize, newItems.size)
    }

    override fun addAtPosition(pos: Int, newItem: Stock) {
        mItems.add(pos, newItem)
        notifyItemInserted(pos)
    }

    override fun remove(position: Int) {
        mItems.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun clearAll() {
        mItems.clear()
        notifyDataSetChanged()
    }
}