package com.example.recyclerview.common

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<Model>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(model: Model)
}