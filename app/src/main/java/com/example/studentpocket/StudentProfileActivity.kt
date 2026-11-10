package com.example.studentpocket

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StudentProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_profile)

        val txtInfo = findViewById<TextView>(R.id.txtProfile);
        val btnBack = findViewById<Button>(R.id.btnBack);

        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ){ v, insets ->
            val bars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )
            v.setPadding(
                bars.left, bars.top, bars.right, bars.bottom
            )
            insets
        }

        val name = intent.getStringExtra("NAME")
        val id = intent.getStringExtra("ID")
        val major = intent.getStringExtra("MAJOR")

        txtInfo.text = "Xin chào $name, mã sinh viên $id, ngành $major"

        btnBack.setOnClickListener {
            finish()
        }
    }
}