package com.example.myapplication

import org.junit.Test
import org.junit.Assert.*

class ExampleUnitTest {

    // ========== 模拟计算状态 ==========
    private var current = ""
    private var previous = ""
    private var op = ""

    private fun clear() {
        current = ""
        previous = ""
        op = ""
    }

    private fun append(s: String) {
        current += s
    }

    private fun appendDot() {
        if ("." !in current) current += "."
    }

    private fun setOp(operator: String) {
        if (current.isNotEmpty()) {
            if (previous.isNotEmpty()) calculate()
            previous = current
            current = ""
            op = operator
        }
    }

    private fun calculate(): String {
        val a = previous.toDoubleOrNull() ?: return "0"
        val b = current.toDoubleOrNull() ?: return "0"
        val result = when (op) {
            "+" -> a + b
            "−" -> a - b
            "*" -> a * b
            "/" -> if (b == 0.0) return "Error" else a / b
            else -> return "0"
        }
        return if (result == result.toLong().toDouble()) result.toLong().toString()
        else result.toString()
    }

    // ========== 7 个功能测试 ==========
    @Test
    fun testAddition() {
        clear()
        append("3")
        setOp("+")
        append("4")
        assertEquals("7", calculate())
    }

    @Test
    fun testSubtraction() {
        clear()
        append("9")
        setOp("−")
        append("4")
        assertEquals("5", calculate())
    }

    @Test
    fun testMultiplication() {
        clear()
        append("6")
        setOp("*")
        append("7")
        assertEquals("42", calculate())
    }

    @Test
    fun testDivision() {
        clear()
        append("8")
        setOp("/")
        append("2")
        assertEquals("4", calculate())
    }

    @Test
    fun testDivisionByZero() {
        clear()
        append("5")
        setOp("/")
        append("0")
        assertEquals("Error", calculate())
    }

    @Test
    fun testClear() {
        append("123")
        clear()
        assertEquals("", current)
        assertEquals("", previous)
    }

    @Test
    fun testDecimal() {
        clear()
        append("1")
        appendDot()
        append("5")
        assertEquals("1.5", current)
    }
}