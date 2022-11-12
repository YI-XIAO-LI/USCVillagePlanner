package com.example.mapapp;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.content.Intent;
import android.util.Log;

import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.mapapp.activity.AddReminderActivity;
import com.example.mapapp.activity.LoginActivity;
import com.example.mapapp.activity.MainActivity;
import com.example.mapapp.activity.MapsActivity;

import junit.framework.AssertionFailedError;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ProfileFragmentTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Before
    public void intentsInit() {
        // initialize Espresso Intents capturing
        Intents.init();
    }

    @After
    public void intentsTeardown() {
        // release Espresso Intents capturing
        Intents.release();
    }

    @Test
    public void navViewIsDisplayed(){

        onView(withId(R.id.nav_view)).check(matches(isDisplayed()));
    }

    @Test
    public void userNameIsDisplayed(){
        onView(ViewMatchers.withId(R.id.nav_view)).perform(click());
        onView(withId(R.id.mTvName)).check(matches(isDisplayed()));
    }

}