package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Data.Search
import kotlinx.android.synthetic.main.search_item.view.*

class SearchQueryAdapter() : RecyclerView.Adapter<SearchQueryAdapter.SearchQueryViewHolder>() {

    private var oldData = emptyList<Search>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchQueryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_item, parent, false)
        return SearchQueryViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchQueryViewHolder, position: Int) {
        holder.itemView.tv_search_query.text = oldData[position].query
    }

    override fun getItemCount(): Int = oldData.size

    class SearchQueryViewHolder(private val view: View) : RecyclerView.ViewHolder(view)

    fun setData(newData: List<Search>) {
        oldData = newData
        notifyDataSetChanged()
    }
}