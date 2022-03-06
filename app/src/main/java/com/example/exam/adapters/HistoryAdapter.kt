package com.example.exam.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.R
import com.example.exam.entities.Payments

class HistoryAdapter(private val array: Array<Payments>, val context: FragmentActivity): RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val title = view.findViewById<TextView>(R.id.text_history)
        val sum = view.findViewById<TextView>(R.id.value_history)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history_payments, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.title.text = item.nameTransaction
        holder.sum.text = item.sumTransaction.toString()
    }

    override fun getItemCount(): Int {
        return array.size
    }
}