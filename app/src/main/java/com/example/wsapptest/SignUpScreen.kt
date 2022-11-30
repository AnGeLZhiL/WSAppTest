package com.example.wsapptest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.wsapptest.databinding.ActivitySignUpScreenBinding

class SignUpScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpScreenBinding
    private val emailRegex = "[a-z0-9]+@[a-z0-9]+\\.+[a-z]{1,3}";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signInOnCllick.setOnClickListener {
            startActivity(Intent(this,SignInScreen::class.java))
        }

        binding.signUp.setOnClickListener {
            if (binding.firstNameEditText.text.isNotEmpty() and binding.secondNameEditText.text.isNotEmpty()
            and binding.emailEditText.text.isNotEmpty() and binding.passwordEditText.text.isNotEmpty()
            and binding.repPasswordEditText.text.isNotEmpty()){
                if (binding.emailEditText.text.toString().trim().matches(emailRegex.toRegex())){
                    if (binding.passwordEditText.text.toString() == binding.repPasswordEditText.text.toString()){
                        startActivity(Intent(this, MainActivity::class.java))
                    }
                    else
                        binding.repPasswordEditText.error = "Пороли не совпадают"
                }
                else
                    binding.emailEditText.error = "Некорректное заполнение"
            }
            else{
                if (binding.firstNameEditText.text.isEmpty()) binding.firstNameEditText.error = "Поле не заполнено"
                if (binding.secondNameEditText.text.isEmpty()) binding.secondNameEditText.error = "Поле не заполнено"
                if (binding.emailEditText.text.isEmpty()) binding.emailEditText.error = "Поле не заполнено"
                if (binding.passwordEditText.text.isEmpty()) binding.passwordEditText.error = "Поле не заполнено"
                if (binding.repPasswordEditText.text.isEmpty()) binding.repPasswordEditText.error = "Поле не заполнено"
            }
        }
    }
}