package com.simplemobiletools.calculator

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.simplemobiletools.calculator.activities.MainActivity
import com.simplemobiletools.calculator.kakao.CalculatorScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityKakaoTest {
    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java)

    private val screen = CalculatorScreen()

    @Test
    fun test() {
        screen {
            button1 {
                isClickable()
                hasText("1")
                click()
            }
            result {
                hasText("1")
            }
        }
    }

    @Test
    fun plusMultipleDigits() {
        screen {
            calculate {
                formula {
                    "1+2+3+5"
                }
            }
            expectResult("11")
        }
    }

    @Test
    fun clear() {
        screen {
            formula {
                "1+2+3+5"
            }
            clear()
            expectResult("0")
        }
    }

    @Test
    fun power() {
        screen {
            calculate {
                formula {
                    "9^2"
                }
            }
            expectResult("81")
        }
    }

    @Test
    fun complexFormula() {
        screen {
            calculate {
                formula {
                    "1+7−3×4÷5^2+6.48"
                }
            }
            expectResult("22.48")
        }
    }

    @Test
    fun percentage() {
        screen {
            calculate {
                formula {
                    "10%20"
                }
            }
            expectResult("2")
        }
    }

    @Test
    fun minusMultiply() {
        screen {
            calculate {
                formula {
                    "-2*5"
                }
            }
            expectResult("-10")
        }
    }
}