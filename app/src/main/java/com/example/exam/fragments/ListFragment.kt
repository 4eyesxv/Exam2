package com.example.exam.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.App
import com.example.exam.R
import com.example.exam.adapters.HistoryAdapter
import com.example.exam.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
        binding.toolbar.titleToolbar.text = "История платежей"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val payments = App.instance?.getDatabase()?.PaymentsDao()?.getAllPayments()
        val recyclerView = view.findViewById<RecyclerView>(R.id.history_recyclerview)
        recyclerView.adapter = HistoryAdapter(payments!!, requireActivity())
    }

}