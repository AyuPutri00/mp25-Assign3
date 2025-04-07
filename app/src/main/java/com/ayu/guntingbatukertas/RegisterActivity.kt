package com.ayu.guntingbatukertas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val username = findViewById<EditText>(R.id.inputUsername)
        val password = findViewById<EditText>(R.id.inputPassword)
        val buttonDaftar = findViewById<Button>(R.id.buttonDaftar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonDaftar.setOnClickListener {
            val usernameDaftar = username.text.toString().trim()
            val passwordDaftar = password.text.toString().trim()
            if ( usernameDaftar.isEmpty() && passwordDaftar.isEmpty() ){
                username.error = "Username tidak boleh kosong!"
                password.error = "Password tidak boleh kosong!"
            } else if (usernameDaftar.isEmpty()) {
                username.error = "Username tidak boleh kosong!"
            } else if(passwordDaftar.isEmpty()){
                password.error = "Password tidak boleh kosong!"
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("PLAYER_USERNAME", usernameDaftar)
                intent.putExtra("PLAYER_PASSWORD", passwordDaftar)
                startActivity(intent)
            }
        }


    }
}