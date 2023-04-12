package com.example.laboratorio04guzman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.laboratorio04guzman.databinding.ActivityShareBinding

class ShareActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShareBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(MainActivity.SHARE_NAME).toString()
        val email = intent.getStringExtra(MainActivity.SHARE_EMAIL).toString()
        val phone = intent.getStringExtra(MainActivity.SHARE_PHONE).toString()
        binding.tvName.text = name
        binding.tvEmail.text = email
        binding.tvPhone.text = phone

        binding.shareAction.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Nombre: ${name}, \n Correo electronico: ${email}, \n Telefono: ${phone}")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

    }
}