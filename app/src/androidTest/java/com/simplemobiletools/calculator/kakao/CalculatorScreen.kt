package com.simplemobiletools.calculator.kakao

import com.agoda.kakao.KButton
import com.agoda.kakao.KTextView
import com.agoda.kakao.Screen
import com.simplemobiletools.calculator.R

class CalculatorScreen : Screen<CalculatorScreen>() {
    val button0 = KButton { withId(R.id.btn_0) }
    val button1 = KButton { withId(R.id.btn_1) }
    val button2 = KButton { withId(R.id.btn_2) }
    val button3 = KButton { withId(R.id.btn_3) }
    val button4 = KButton { withId(R.id.btn_4) }
    val button5 = KButton { withId(R.id.btn_5) }
    val button6 = KButton { withId(R.id.btn_6) }
    val button7 = KButton { withId(R.id.btn_7) }
    val button8 = KButton { withId(R.id.btn_8) }
    val button9 = KButton { withId(R.id.btn_9) }
    val buttonPlus = KButton { withId(R.id.btn_plus) }
    val buttonMinus = KButton { withId(R.id.btn_minus) }
    val buttonMultiply = KButton { withId(R.id.btn_multiply) }
    val buttonDecimal = KButton { withId(R.id.btn_decimal) }
    val buttonDivide = KButton { withId(R.id.btn_divide) }
    val buttonClear = KButton { withId(R.id.btn_clear) }
    val buttonPercent = KButton { withId(R.id.btn_percent) }
    val buttonReset = KButton { withId(R.id.btn_reset) }
    val buttonEquals = KButton { withId(R.id.btn_equals) }
    val buttonPower = KButton { withId(R.id.btn_power) }
    val result = KTextView { withId(R.id.result) }
    private val map = mapOf(
            '1' to button1,
            '2' to button2,
            '3' to button3,
            '4' to button4,
            '5' to button5,
            '6' to button6,
            '7' to button7,
            '8' to button8,
            '9' to button9,
            '0' to button0,
            '-' to buttonMinus,
            '−' to buttonMinus,
            '*' to buttonMultiply,
            '×' to buttonMultiply,
            '/' to buttonDivide,
            '÷' to buttonDivide,
            '+' to buttonPlus,
            '.' to buttonDecimal,
            '^' to buttonPower,
            '%' to buttonPercent,
            '=' to buttonEquals
    )

    fun formula(actions: () -> String) {
        val formula = actions()
        for (action in formula) {
            val kButton = map[action]
            kButton?.click()
        }
    }

    fun calculate() {
        buttonEquals.click()
    }

    fun calculate(actions: () -> Unit) {
        actions()
        buttonEquals.click()
    }

    fun expectResult(value: String) {
        result {
            hasText(value)
        }
    }

    fun clear() {
        buttonClear.click()
    }
}