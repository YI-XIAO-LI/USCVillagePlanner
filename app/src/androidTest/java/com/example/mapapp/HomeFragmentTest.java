package com.example.mapapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.ext.truth.content.IntentSubject.assertThat;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.mapapp.activity.AddRestaurantActivity;
import com.google.common.collect.Iterables;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import androidx.test.filters.LargeTest;

import com.example.mapapp.freament.HomeFragment;
import com.example.mapapp.activity.MainActivity;
import com.example.mapapp.activity.AddReminderActivity;



import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class HomeFragmentTest {
    @Rule public ActivityScenarioRule<MainActivity> activityScenarioRule =
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
    public void mapIsDisplayed(){
        onView(withId(R.id.mapView)).check(matches(isDisplayed()));
    }

    @Test
    public void addRemindersButton(){
        onView(withId(R.id.mTvAddReminder)).check(matches(isDisplayed()));
    }

    @Test
    public void testClickAddReminderButtonNav(){
        onView(ViewMatchers.withId(R.id.mTvAddReminder)).perform(click());

        intended(hasComponent(AddReminderActivity.class.getName()));

    }

    @Test
    public void testClickAddRestaurantButtonNav(){
        onView(ViewMatchers.withId(R.id.mTvAddRestaurant)).perform(click());

        intended(hasComponent(AddRestaurantActivity.class.getName()));

    }


}
