package com.example.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun launch() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun close() {
        scenario.close()
    }

    /* ========== 7 大功能验证 ========== */

    @Test
    fun testAddition() {
        // 3 + 4 = 7
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonAdd)).perform(click())
        onView(withId(R.id.button4)).perform(click())
        onView(withId(R.id.buttonEq)).perform(click())
        onView(withId(R.id.resultText)).check(matches(withText("7")))
    }

    @Test
    fun testSubtraction() {
        // 9 − 4 = 5
        onView(withId(R.id.button9)).perform(click())
        onView(withId(R.id.buttonSub)).perform(click())
        onView(withId(R.id.button4)).perform(click())
        onView(withId(R.id.buttonEq)).perform(click())
        onView(withId(R.id.resultText)).check(matches(withText("5")))
    }

    @Test
    fun testMultiplication() {
        // 6 × 7 = 42
        onView(withId(R.id.button6)).perform(click())
        onView(withId(R.id.buttonMul)).perform(click())
        onView(withId(R.id.button7)).perform(click())
        onView(withId(R.id.buttonEq)).perform(click())
        onView(withId(R.id.resultText)).check(matches(withText("42")))
    }

    @Test
    fun testDivision() {
        // 8 ÷ 2 = 4
        onView(withId(R.id.button8)).perform(click())
        onView(withId(R.id.buttonDiv)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonEq)).perform(click())
        onView(withId(R.id.resultText)).check(matches(withText("4")))
    }

    @Test
    fun testClear() {
        // 123 → C → 0
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonC)).perform(click())
        onView(withId(R.id.resultText)).check(matches(withText("0")))
    }

    @Test
    fun testDecimal() {
        // 1 . 5 → 1.5
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonDot)).perform(click())
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.resultText)).check(matches(withText("1.5")))
    }

    @Test
    fun testEquals() {
        // 2 + 3 = 5
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonAdd)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonEq)).perform(click())
        onView(withId(R.id.resultText)).check(matches(withText("5")))
    }
}