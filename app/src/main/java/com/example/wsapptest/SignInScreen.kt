package com.example.wsapptest

import android.app.AlertDialog
import android.content.Intent
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.example.wsapptest.databinding.ActivitySignInScreenBinding
import com.squareup.picasso.Picasso
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

//import okio.IOException
//import java.io.IOException

class SignInScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySignInScreenBinding
    private val emailRegex = "[a-z0-9]+@[a-z0-9]+\\.+[a-z]{1,3}"
    private lateinit var builder: AlertDialog.Builder
    private val client = OkHttpClient()


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
//                            startActivity(Intent(this, MainActivity::class.java))
                            val requestBody =
                                ("{" +
                                        "\"user\":{" +
                                            "\"email\":\"${binding.emailEditText.text}\"," +
                                            "\"password\":\"${binding.passwordEditText.text}\"" +
                                        "}" +
                                "}").toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
                            val request = Request.Builder()
                                .url("http://172.20.8.20/bgxxparc/api/user/login")
                                .post(requestBody)
                                .build()
//                            client.newCall(request).enqueue(object: Callback {
//                                override fun onFailure(call: Call, e: okio.IOException) {
//                                    println("LELAKDHSOIAJBUAISFJKIK")
//                                    Log.e("ERROR", e.toString())
//                                }
//
//                                override fun onResponse(call: Call, response: Response) {
//                                    println("OLALALAOLAOLAOLAOLAOA " + response.code)
//                                    println(response.body.string())
//                                }
//
//                            })
                            client.newCall(request).enqueue(object: Callback {
                                override fun onFailure(call: Call, e: okio.IOException) {
                                    println("LELAKDHSOIAJBUAISFJKIK")
                                    Log.e("ERROR", e.toString())
                                }

                                override fun onResponse(call: Call, response: Response) {
                                    println("OLALALAOLAOLAOLAOLAOA " + response.code)
                                    val json = response.body.string()
                                    val strUrl = JSONObject(json)
                                    .getJSONObject("user").getString("image")
                                    println("-------------------")
                                    val iV = findViewById<ImageView>(R.id.imageView)
                                    Global.imgUrl = strUrl
                                    println(strUrl)
                                    startActivity(Intent(this@SignInScreen,MainActivity::class.java))
                                }

                            })
//                            client.newCall(request).execute().use { response ->
//                                if (!response.isSuccessful) throw IOException("Unexpected code $response")
//
//                                println(response.body!!.string())
//                            }
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