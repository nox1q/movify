package com.example.recyclerview.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<Model>(
    private val items: List<Model>
) : RecyclerView.Adapter<BaseViewHolder<Model>>() {

    override fun onBindViewHolder(
        holder: BaseViewHolder<Model>,
        position: Int
    ) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    fun getInflatedView(
        @LayoutRes layoutResId: Int,
        parent: ViewGroup
    ): View = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
}