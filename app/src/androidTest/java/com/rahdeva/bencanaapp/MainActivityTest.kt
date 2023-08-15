package com.rahdeva.bencanaapp

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeDown
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.rahdeva.bencanaapp.presentation.main.ui.MainActivity
import com.rahdeva.bencanaapp.utils.testing.EspressoResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val rule =  ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup(){
        launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoResource.idlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoResource.idlingResource)
    }

    @Test
    fun isMapsDisplayed(){
        onView(withId(R.id.maps)).check(matches(isDisplayed()))
    }

    @Test
    fun testDisasterList(){
        onView(withId(R.id.rv_disaster_list)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_disaster_list)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                5
            )
        )
        onView(withId(R.id.rv_disaster_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
    }

    @Test
    fun testFilterDisaster(){
        onView(withId(R.id.rv_disaster_filter)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_disaster_filter)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                4
            )
        )
        onView(withId(R.id.rv_disaster_filter)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
    }

    @Test
    fun testSearchBar(){
        onView(withId(R.id.search_main)).check(matches(isDisplayed()))
        onView(withId(R.id.search_main)).perform(
            click()
        )
        onView(withId(R.id.cv_list_search_suggestion)).check(matches(isDisplayed()))
        onView(withId(R.id.cv_list_search_suggestion)).perform(swipeDown())
        onView(withId(R.id.cv_list_search_suggestion)).perform(
            click()
        )
    }

}