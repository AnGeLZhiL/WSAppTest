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
import okhttp3.*
import okio.IOException
import org.json.JSONObject

class CollectionsScreen : Fragment() {

    private lateinit var binding: FragmentCollectionsScreenBinding
    private val client = OkHttpClient()

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


        val request = Request.Builder()
            .url("http://172.20.8.20/bgxxparc/api/movie")
            .build()
        val list =ArrayList<classModel>()
        client.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {

                val json = response.body.string()
                val jsonArray = JSONObject(json).getJSONObject("movies").getJSONArray("data")
                for (i in 0 until jsonArray.length()){
                    val array = jsonArray[i] as JSONObject
                    list.add(
                        classModel(
                        name = array.getString("image"),
                        count = array.getString("name")
                    )
                    )
                    println(array.getString("name"))
                }
                list.add(
                    classModel(
                        name = "",
                        count = "Test"
                    ))
                println("-----------------------------------")
                println("-----------    " + list.count())

            }

        })
        binding.recyclerView.adapter = itemAdapter(list)
//        binding.recyclerView.adapter = itemAdapter(list)
    }
}