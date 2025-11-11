package com.example.tugasuts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inisialisasi
        val editUsername = findViewById<EditText>(R.id.editUsername)
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editFirstName = findViewById<EditText>(R.id.editFirstName)
        val editLastName = findViewById<EditText>(R.id.editLastName)
        val editPassword = findViewById<EditText>(R.id.editPassword)
        val editConfirmPassword = findViewById<EditText>(R.id.editConfirmPassword)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnCancel = findViewById<Button>(R.id.btnCancel)

        // Tombol Submit ditekan
        btnSubmit.setOnClickListener {
            val username = editUsername.text.toString().trim()
            val email = editEmail.text.toString().trim()
            val firstName = editFirstName.text.toString().trim()
            val lastName = editLastName.text.toString().trim()
            val password = editPassword.text.toString()
            val confirmPassword = editConfirmPassword.text.toString()

            // Validasi input kosong
            if (username.isEmpty() || email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() ||
                password.isEmpty() || confirmPassword.isEmpty()
            ) {
                Toast.makeText(this, "Semua inputan harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validasi password dan konfirmasi
            if (password != confirmPassword) {
                Toast.makeText(this, "Password dan konfirmasi tidak sama!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Jika semua valid → tampilkan notifikasi
            val fullName = "$firstName $lastName"
            Toast.makeText(this, "Pendaftaran berhasil! Selamat datang, $fullName", Toast.LENGTH_LONG).show()
        }

        // Tombol Cancel untuk reset form
        btnCancel.setOnClickListener {
            editUsername.text.clear()
            editEmail.text.clear()
            editFirstName.text.clear()
            editLastName.text.clear()
            editPassword.text.clear()
            editConfirmPassword.text.clear()
            Toast.makeText(this, "Formulir telah dibersihkan", Toast.LENGTH_SHORT).show()
        }
    }
}
