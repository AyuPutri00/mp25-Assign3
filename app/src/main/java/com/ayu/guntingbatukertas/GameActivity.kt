package com.ayu.guntingbatukertas

import android.graphics.Color
import androidx.core.content.ContextCompat
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {
    private val pilihan = arrayOf("Gunting", "Batu", "Kertas")
    private var pilihanPlayer: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val playerName = intent.getStringExtra("PLAYER_USERNAME")

        val tvPlayer = findViewById<TextView>(R.id.tvPlayer)
        val imgBotChoice = findViewById<ImageView>(R.id.imgBotChoice)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)
        val btnLawan = findViewById<Button>(R.id.btnLawan)

        val btnGunting = findViewById<ImageView>(R.id.btnGunting)
        val btnBatu = findViewById<ImageView>(R.id.btnBatu)
        val btnKertas = findViewById<ImageView>(R.id.btnKertas)

        val btnBack = findViewById<Button>(R.id.btnBack)

        tvPlayer.text = "Player: $playerName"

        // fungsi untuk mengubah border saat dipilih
        fun selectChoice(choice: String, imageView: ImageView) {
            pilihanPlayer = choice
            btnGunting.setBackgroundColor(Color.TRANSPARENT)
            btnBatu.setBackgroundColor(Color.TRANSPARENT)
            btnKertas.setBackgroundColor(Color.TRANSPARENT)

            val purple = ContextCompat.getColor(this, R.color.purple)
            imageView.setBackgroundColor(purple)
        }

        // set listener untuk pilihan
        btnGunting.setOnClickListener { selectChoice("Gunting", btnGunting) }
        btnBatu.setOnClickListener { selectChoice("Batu", btnBatu) }
        btnKertas.setOnClickListener { selectChoice("Kertas", btnKertas) }

        btnLawan.setOnClickListener {
            if (pilihanPlayer == null) {
                Toast.makeText(this, "Pilih dulu!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val pilihanBot = pilihan.random()

            // set gambar pilihan bot
            val botDrawable = when (pilihanBot) {
                "Gunting" -> R.drawable.gunting
                "Batu" -> R.drawable.batu
                else -> R.drawable.kertas
            }

            imgBotChoice.setImageResource(botDrawable)
            imgBotChoice.visibility = ImageView.VISIBLE // Tampilkan gambar bot

            // menentukan pemenang
            val hasil = when {
                pilihanPlayer == pilihanBot -> "Seri!"
                pilihanPlayer == "Gunting" && pilihanBot == "Kertas" ||
                        pilihanPlayer == "Batu" && pilihanBot == "Gunting" ||
                        pilihanPlayer == "Kertas" && pilihanBot == "Batu" -> "$playerName Menang!"
                else -> "Bot Menang!"
            }

            tvHasil.text = hasil
        }

        // set listener untuk button kembali
        btnBack.setOnClickListener {
            finish() // Menutup GameActivity dan kembali ke activity sebelumnya (MainActivity)
        }
    }

}
