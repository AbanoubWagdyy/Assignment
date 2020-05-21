package com.app.ui.homepage.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.R
import com.app.data.model.Result
import com.app.extensions.inflate

class TimesAdapter(private var timeList: List<Result>) :
    RecyclerView.Adapter<TimesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(parent.inflate(R.layout.result_list_item, false))
    }

    override fun getItemCount(): Int = timeList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


    class MyViewHolder(
        v: View
    ) : RecyclerView.ViewHolder(v) {

        private var view: View = v
        private var title: TextView

        init {
            title = view.findViewById(R.id.title)
        }

        fun bindTimesData(result: Result) {

        }
    }
}