package com.example.androidlaboratory

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemoAdapter(private val memoList: ArrayList<Memo>)
    : RecyclerView.Adapter<MemoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.layout_title)
        var content: TextView = itemView.findViewById(R.id.layout_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.memo_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = memoList[position].title
        holder.content.text = memoList[position].content
    }

    override fun getItemCount(): Int {
        return memoList.size
    }
}