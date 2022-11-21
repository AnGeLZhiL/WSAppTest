package com.example.wsapptest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.wsapptest.databinding.ActivitySignInScreenBinding

class SignInScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySignInScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun SignUp_onClick(view: View) {
        startActivity(Intent(this, SignInScreen::class.java))
    }
}