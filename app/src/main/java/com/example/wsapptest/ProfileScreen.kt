package com.example.wsapptest

import android.os.Bundle
import android.provider.Settings.Global
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.wsapptest.Global.Companion.imgUrl
import com.example.wsapptest.databinding.FragmentProfileScreenBinding
import com.squareup.picasso.Picasso

class ProfileScreen : Fragment() {
    private lateinit var binding: FragmentProfileScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.idTextView.setOnClickListener {
            findNavController().navigate(R.id.action_profileScreen_to_testFragment)
        }
        Picasso.get().load(com.example.wsapptest.Global.imgUrl).into(binding.imgUser)
    }
}