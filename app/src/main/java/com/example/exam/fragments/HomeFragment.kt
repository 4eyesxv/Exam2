package com.example.exam.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exam.App
import com.example.exam.adapters.CategoryAdapter
import com.example.exam.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.toolbar.titleToolbar.text = "Категории"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbCategory = App.instance?.getDatabase()?.CategoryDao()
        val recyclerView = binding.categorySelectRecyclerview
        recyclerView.adapter = CategoryAdapter(dbCategory!!.getAllCategory(), requireActivity())
    }
}