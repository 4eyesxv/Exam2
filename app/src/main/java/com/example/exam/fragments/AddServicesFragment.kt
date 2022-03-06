package com.example.exam.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import com.example.exam.App
import com.example.exam.databinding.FragmentAddServicesBinding
import com.example.exam.entities.Services

class AddServicesFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private var _binding: FragmentAddServicesBinding? = null
    private val binding get() = _binding!!
    var categoryId: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddServicesBinding.inflate(inflater, container, false)
        binding.toolbar.titleToolbar.text = "Добавить Услугу"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbServices = App.instance?.getDatabase()?.ServicesDao()
        val dbCategory = App.instance?.getDatabase()?.CategoryDao()
        val categoryName = dbCategory?.getNameCategory()
        binding.addCategoryBtn.setOnClickListener {
            findNavController()
                .navigate(AddServicesFragmentDirections.actionAddServicesFragmentToAddCategoryFragment())
        }

        spinnerCategory(binding.chooseCategorySpinner, categoryName!!)
        binding.chooseCategorySpinner.onItemSelectedListener = this

        binding.saveServiceBtn.setOnClickListener {
            dbServices?.addServices(
                Services(
                idService = null,
                nameService = binding.addServiceEt.text.toString(),
                fkCategory = categoryId
            )
            )
            Log.d("DDDD", "${dbServices?.getAllServices()}")
        }

    }
    fun spinnerCategory(spinner: Spinner, list: List<String>){
        val adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, list)
        spinner.setAdapter(adapter)
    }

    override fun onItemSelected(item: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val category = App.instance?.getDatabase()?.CategoryDao()?.getAllCategory()
        for (i in category!!){
            if (item?.selectedItem == i.nameCategory){
                categoryId = i.idCategory
            }
        }
    }

    override fun onNothingSelected(item: AdapterView<*>?) {
    }
}