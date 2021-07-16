package com.qbo.apptvqboespresso


import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    //@get:Rule var activityTestScenarioRule = activityScenarioRule<MainActivity>()
    @get:Rule var intentTestScenarioRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun ingresoDeDatos(){
        onView(withId(R.id.etnombre))
            .perform(typeText("Julio"), closeSoftKeyboard())
            //.check()

        onView(withId(R.id.etapellido))
            .perform(typeText("Montoya"),
            closeSoftKeyboard())

        onView(withId(R.id.rbmasculino))
            .perform(click())

        onView(withId(R.id.btnregistrar))
            .perform(click())

        intending(hasExtraWithKey("nombre"))

        val datosRecibidos : Intent =
            Iterables.getOnlyElement(Intents.getIntents())
        assertEquals(datosRecibidos.extras!!.getString("nombre"),
            "Pedro")

    }


}