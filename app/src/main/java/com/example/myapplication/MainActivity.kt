package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var resultText: TextView
    private var current = ""
    private var previous = ""
    private var op = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultText = findViewById(R.id.resultText)

        // 0-9 数字
        listOf(
            R.id.button0, R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6, R.id.button7,
            R.id.button8, R.id.button9
        ).forEach { id ->
            findViewById<Button>(id).setOnClickListener { append((it as Button).text.toString()) }
        }

        // 7 个功能键
        findViewById<Button>(R.id.buttonDot).setOnClickListener { appendDot() }
        findViewById<Button>(R.id.buttonC).setOnClickListener { clear() }
        findViewById<Button>(R.id.buttonAdd).setOnClickListener { setOp("+") }
        findViewById<Button>(R.id.buttonSub).setOnClickListener { setOp("−") }
        findViewById<Button>(R.id.buttonMul).setOnClickListener { setOp("*") }
        findViewById<Button>(R.id.buttonDiv).setOnClickListener { setOp("/") }
        findViewById<Button>(R.id.buttonEq).setOnClickListener { calculate() }
    }

    private fun append(s: String) { current += s; refresh() }
    private fun appendDot() { if ("." !in current) { current += "."; refresh() } }
    private fun clear() { current = ""; previous = ""; op = ""; refresh() }
    private fun setOp(operator: String) {
        if (current.isNotEmpty()) {
            if (previous.isNotEmpty()) calculate()
            previous = current; current = ""; op = operator
        }
    }
    private fun calculate() {
        val a = previous.toDoubleOrNull() ?: return
        val b = current.toDoubleOrNull() ?: return
        current = when (op) {
            "+" -> (a + b).toString()
            "−" -> (a - b).toString()
            "*" -> (a * b).toString()
            "/" -> if (b == 0.0) {
                Toast.makeText(this, "不能除以0", Toast.LENGTH_SHORT).show(); return
            } else (a / b).toString()
            else -> return
        }.let { if (it.endsWith(".0")) it.dropLast(2) else it }
        previous = ""; op = ""; refresh()
    }
    private fun refresh() { resultText.text = if (current.isEmpty()) "0" else current }
}