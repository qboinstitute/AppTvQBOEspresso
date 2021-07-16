package com.qbo.apptvqboespresso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qbo.apptvqboespresso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnregistrar.setOnClickListener {
            var intentDatos = Intent(
                    applicationContext,
                    DatosActivity::class.java
            )
            intentDatos.apply {
                putExtra("nombre", binding.etnombre.text.toString())
            }
            startActivity(intentDatos)
        }
    }
}