package com.example.project2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class SecondActivity : AppCompatActivity() {
    lateinit var mainbutton : Button
    lateinit var thirdbutton : Button
    lateinit var factButton : Button
    lateinit var factEdit : EditText
    lateinit var factText : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        xyz()

        factButton = findViewById(R.id.factButton)
        factEdit = findViewById(R.id.factEdit)
        factText = findViewById(R.id.factText)

        factButton.setOnClickListener {
            val x: Int = factEdit.text.toString().toInt()
            factText.text = fact(x).toString()
        }
    }
    fun fact(a : Int ): Int {
        if (a == 1){
            return 1
        }
        return a * fact(a - 1)
    }
    fun xyz() {
        mainbutton = findViewById(R.id.button3)
        thirdbutton = findViewById(R.id.button2)
        var mainActivity = Intent(this, MainActivity :: class.java)
        mainbutton.setOnClickListener {
            startActivity(mainActivity)
        }
        var secondActivity = Intent(this, ThirdActivity :: class.java)
        thirdbutton.setOnClickListener {
            startActivity(secondActivity)
        }
    }

}
