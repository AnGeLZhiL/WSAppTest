package com.example.wsapptest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wsapptest.adapter.itemAdapter
import com.example.wsapptest.databinding.FragmentCollectionsScreenBinding
import com.example.wsapptest.model.classModel

class CollectionsScreen : Fragment() {

    private lateinit var binding: FragmentCollectionsScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCollectionsScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager =LinearLayoutManager(context)
        binding.recyclerView.setHasFixedSize(true)
        val list =ArrayList<classModel>()
        list.add(
            classModel(
            "Привет",
            90
            )
        )
        list.add(classModel(
            "Пока",
            80
        ))
        list.add(classModel(
            "Хочу умереть!!!",
            70
        ))
        list.add(classModel(
            "Я ОЧЕНЬ ХОЧУ УМЕРЕТЬ НО СНАЧАЛА ПОКУШАТЬ!",
            70
        ))
        list.add(classModel(
            "Я ОЧЕНЬ ГОЛОДЕН!",
            70
        ))
        binding.recyclerView.adapter = itemAdapter(list)
    }
}