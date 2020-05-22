package com.app.ui.homepage.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.R
import com.app.extensions.inflate
import com.app.data.model.Result

class TimesAdapter(private var timeList: List<Result>) :
    RecyclerView.Adapter<TimesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(parent.inflate(R.layout.result_list_item, false))
    }

    override fun getItemCount(): Int = timeList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val result = timeList[position]
        holder.bindTimesData(result)
    }


    class MyViewHolder(
        v: View
    ) : RecyclerView.ViewHolder(v) {

        private var view: View = v
        private var title: TextView
        private var author: TextView
        private var description: TextView
        private var date: TextView

        init {
            title = view.findViewById(R.id.title)
            author = view.findViewById(R.id.author)
            description = view.findViewById(R.id.description)
            date = view.findViewById(R.id.date)
        }

        fun bindTimesData(result: Result) {

            title.text = result.title
            author.text = result.byline
            description.text = result.abstract
            date.text = result.updated
        }
    }
}