package com.example.wsapptest

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.wsapptest.databinding.ActivitySignInScreenBinding

class SignInScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySignInScreenBinding
    private val emailRegex = "[a-z0-9]+@[a-z0-9]+\\.+[a-z]{1,3}"
    private lateinit var builder: AlertDialog.Builder


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        builder = AlertDialog.Builder(this)

        binding.signInOnClick.setOnClickListener {
            if (binding.emailEditText.text.isNotEmpty() and binding.emailEditText.text.isNotEmpty()){
                if (binding.emailEditText.text.toString().trim().matches(emailRegex.toRegex())){
                    builder.setTitle("Оло")
                        .setMessage("Вы уверены в своих действиях?")
                        .setCancelable(true)
                        .setPositiveButton("Yes"){ dialogInterfce, it ->
                            startActivity(Intent(this, MainActivity::class.java))
                        }
                        .setNegativeButton("No"){dialogInterfce,it ->
                            dialogInterfce.cancel()
                        }
                        .show()
                }
                else
                    binding.emailEditText.error = "Не соответствует почте"
            }
            else {
                if (binding.passwordEditText.text.isEmpty()) binding.passwordEditText.error = "Поле не заполнено"
                if (binding.emailEditText.text.isEmpty()) binding.emailEditText.error = "Поле не заполнено"
            }
        }

        binding.signUpOnClick.setOnClickListener {
            startActivity(Intent(this, SignUpScreen::class.java))
        }
    }
}