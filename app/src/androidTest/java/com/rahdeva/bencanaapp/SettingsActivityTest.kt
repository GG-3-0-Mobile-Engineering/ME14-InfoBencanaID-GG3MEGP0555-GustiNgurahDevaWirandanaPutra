package com.rahdeva.bencanaapp

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.rahdeva.bencanaapp.presentation.main.ui.MainActivity
import com.rahdeva.bencanaapp.utils.testing.EspressoResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SettingsActivityTest {
    @get:Rule
    val rule =  ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup(){
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoResource.idlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoResource.idlingResource)
    }

    @Test
    fun testSettings(){
        onView(withId(R.id.btn_settings)).perform(
            click()
        )
        onView(withId(R.id.tv_settings_title)).check(matches(isDisplayed()))
        onView(withId(R.id.switch_night)).perform(
            click()
        )
        onView(withId(R.id.switch_notification)).perform(
            click()
        )
    }
}