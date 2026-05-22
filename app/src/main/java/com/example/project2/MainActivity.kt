package com.example.project2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var secondButton : Button
    lateinit var thirdButton : Button

    lateinit var evenButton : Button
    lateinit var evenEdit : EditText
    lateinit var evenText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityIntent()

        evenButton = findViewById(R.id.evenButton)
        evenEdit = findViewById(R.id.evenEdit)
        evenText = findViewById(R.id.evenText)

        evenButton.setOnClickListener {
            val x: Int = evenEdit.text.toString().toInt()
            evenText.text = isEven(x)
        }
    }
    fun isEven(a: Int): String {
        if ((a % 2) == 0) {
            return "Even"
        }
        return "odd"
    }
    fun activityIntent() {
        secondButton = findViewById(R.id.button3)
        thirdButton = findViewById(R.id.button2)

        val secondActivity = Intent(this, SecondActivity::class.java)
        secondButton.setOnClickListener {
            startActivity(secondActivity)
        }
        val thirdActivity = Intent(this, ThirdActivity::class.java)
        thirdButton.setOnClickListener {
            startActivity(thirdActivity)
        }
    }

}
