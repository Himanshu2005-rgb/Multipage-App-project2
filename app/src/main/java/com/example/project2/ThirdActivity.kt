package com.example.project2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class ThirdActivity : AppCompatActivity() {
    private lateinit var mainButton: Button
    private lateinit var secondButton: Button
    private lateinit var resultText: TextView
    private var firstOperand: Double = 0.0
    private var secondOperand: Double = 0.0
    private var operator: String? = null
    private var isNewOp = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_activity)

        resultText = findViewById(R.id.resultText)
        
        setupNavigation()
        setupCalculator()
    }
    private fun setupNavigation() {
        mainButton = findViewById(R.id.button3)
        secondButton = findViewById(R.id.button2)
        mainButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        secondButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
    private fun setupCalculator() {
        val buttons = listOf(
            R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four,
            R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine
        )
        for (id in buttons) {
            findViewById<Button>(id).setOnClickListener {
                onDigitClick((it as Button).text.toString())
            }
        }
        findViewById<Button>(R.id.plus).setOnClickListener { onOperatorClick("+") }
        findViewById<Button>(R.id.subtract).setOnClickListener { onOperatorClick("-") }
        findViewById<Button>(R.id.mul).setOnClickListener { onOperatorClick("*") }
        findViewById<Button>(R.id.divide).setOnClickListener { onOperatorClick("/") }
        findViewById<Button>(R.id.decimal).setOnClickListener { onDecimalClick() }
        findViewById<Button>(R.id.equal).setOnClickListener { onEqualClick() }
    }
    private fun onDigitClick(digit: String) {
        if (isNewOp) {
            resultText.text = digit
            isNewOp = false
        } else {
            resultText.append(digit)
        }
    }
    private fun onDecimalClick() {
        if (isNewOp) {
            resultText.text = "0."
            isNewOp = false
        } else if (!resultText.text.contains(".")) {
            resultText.append(".")
        }
    }
    private fun onOperatorClick(op: String) {
        firstOperand = resultText.text.toString().toDoubleOrNull() ?: 0.0
        operator = op
        isNewOp = true
    }
    private fun onEqualClick() {
        secondOperand = resultText.text.toString().toDoubleOrNull() ?: 0.0
        val result = when (operator) {
            "+" -> firstOperand + secondOperand
            "-" -> firstOperand - secondOperand
            "*" -> firstOperand * secondOperand
            "/" -> if (secondOperand != 0.0) firstOperand / secondOperand else Double.NaN
            else -> secondOperand
        }
        resultText.text = if (result % 1 == 0.0) {
            result.toLong().toString()
        } else {
            result.toString()
        }
        isNewOp = true
        operator = null
    }
}
