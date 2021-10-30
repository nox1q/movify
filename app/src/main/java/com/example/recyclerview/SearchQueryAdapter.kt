package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Data.Search
import kotlinx.android.synthetic.main.search_item.view.*

class SearchQueryAdapter(val onQuerySearchClickListener: OnQuerySearchClickListener) :
    RecyclerView.Adapter<SearchQueryAdapter.SearchQueryViewHolder>() {

    private var queryList = emptyList<Search>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchQueryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_item, parent, false)
        return SearchQueryViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchQueryViewHolder, position: Int) {
        holder.itemView.tv_search_query.text = queryList[position].query
        holder.itemView.setOnClickListener {
            onQuerySearchClickListener.onQuerySearchClicked(queryList[position].query)
        }
    }

    override fun getItemCount(): Int = queryList.size

    class SearchQueryViewHolder(view: View) : RecyclerView.ViewHolder(view)

    fun setData(query: List<Search>) {
        this.queryList = query
        notifyDataSetChanged()
    }
}