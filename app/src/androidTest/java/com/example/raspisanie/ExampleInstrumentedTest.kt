package com.example.raspisanie

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ButtonViewTableTest {

    @Before
    fun setUp() {
        Intents.init()
    }

    @Test
    fun testButtonStudentOpensViewTableStudent() {
        ActivityScenario.launch(ButtonViewTable::class.java)
        onView(withId(R.id.button3)).perform(click())
        Intents.intended(hasComponent(ViewTableStudent::class.java.name))
    }

    @Test
    fun testButtonTeacherOpensViewTableTeachers() {
        ActivityScenario.launch(ButtonViewTable::class.java)
        onView(withId(R.id.button2)).perform(click())
        Intents.intended(hasComponent(ViewTableTeachers::class.java.name))
    }

    @Test
    fun testButtonCabinetsOpensViewTableCabinets() {
        ActivityScenario.launch(ButtonViewTable::class.java)
        onView(withId(R.id.button4)).perform(click())
        Intents.intended(hasComponent(ViewTableCabinets::class.java.name))
    }

    @After
    fun tearDown() {
        Intents.release()
    }
}
