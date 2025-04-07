package com.ayu.guntingbatukertas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val inputUsername = findViewById<EditText>(R.id.inputUsername)
        val inputPassword = findViewById<EditText>(R.id.inputPassword)
        val buttonMain = findViewById<Button>(R.id.buttonMain)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)

        val usernameDaftar = intent.getStringExtra("PLAYER_USERNAME")
        val passwordDaftar = intent.getStringExtra("PLAYER_PASSWORD")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonMain.setOnClickListener {
            val username = inputUsername.text.toString().trim()
            val password = inputPassword.text.toString().trim()
            if(username.isEmpty() && password.isEmpty()){
                inputUsername.error = "Username tidak boleh kosong!"
                inputPassword.error = "Password tidak boleh kosong!"
            } else if (username.isEmpty()) {
                inputUsername.error = "Username tidak boleh kosong!"
            } else if(password.isEmpty()){
                inputPassword.error = "Password tidak boleh kosong!"
            } else {
                if(username!=usernameDaftar && password!=passwordDaftar){
                    inputUsername.error = "Username salah!"
                    inputPassword.error = "Password salah!"
                } else if (username!=usernameDaftar){
                    inputUsername.error = "Username salah!"
                } else if(password!=passwordDaftar){
                    inputPassword.error = "Password salah!"
                } else{
                    val intent = Intent(this, GameActivity::class.java)
                    intent.putExtra("PLAYER_USERNAME", usernameDaftar)
                    intent.putExtra("PLAYER_PASSWORD", passwordDaftar)
                    startActivity(intent)
                }
            }
        }

        buttonRegister.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}