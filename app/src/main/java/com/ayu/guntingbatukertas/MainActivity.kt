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

        val inputNama = findViewById<EditText>(R.id.inputNama)
        val buttonMain = findViewById<Button>(R.id.buttonMain)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonMain.setOnClickListener {
            val nama = inputNama.text.toString().trim()
            if (nama.isEmpty()) {
                inputNama.error = "Nama tidak boleh kosong!"
            } else {
                val intent = Intent(this, GameActivity::class.java)
                intent.putExtra("PLAYER_NAME", nama)
                startActivity(intent)
            }
        }

    }
}