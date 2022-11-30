package com.example.wsapptest

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.wsapptest.databinding.FragmentTestBinding

class TestFragment : Fragment() {
    private lateinit var binding: FragmentTestBinding
    private lateinit var builder: AlertDialog.Builder

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTestBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        builder = AlertDialog.Builder(activity)

        binding.backButton.setOnClickListener {
            builder.setTitle("Привет")
                .setMessage("Может домой?")
                .setPositiveButton("Да!!"){ dialog, it ->
                    Toast.makeText(activity, "Закрывай все и иди домой", Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_testFragment_to_profileScreen)
                }
                .setNegativeButton("Конечно да!"){ dialog, it ->
                    Toast.makeText(activity, "Закрывай все и иди домой", Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_testFragment_to_profileScreen)
                }
                .show()
        }
    }

}