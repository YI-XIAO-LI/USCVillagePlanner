package com.example.mapapp;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.hasChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import static com.google.common.base.CharMatcher.is;
import static com.google.common.truth.Truth.assertThat;
import static kotlin.jvm.internal.Intrinsics.checkNotNull;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.mapapp.activity.AddReminderActivity;
import com.example.mapapp.activity.LoginActivity;
import com.example.mapapp.activity.MainActivity;
import com.example.mapapp.activity.MapsActivity;
import com.example.mapapp.tool.Config;

import junit.framework.AssertionFailedError;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RemindersFragmentTest {
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
    public void arrivalTimeIsDisplayedCorrectly(){
        onView(ViewMatchers.withId(R.id.mTvAddReminder)).perform(click());
        onView(withId(R.id.mEtAt)).check(matches(isDisplayed()));
        onView(withId(R.id.mEtAt)).perform(click());
        // pick a picker, set it to 11:11, and check if it is working as intended
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName()))).perform(PickerActions.setTime(11, 11));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.mEtAt)).check(matches(withText("11:11")));
    }

    @Test
    public void testReminderAddCancel() throws InterruptedException {
        onView(ViewMatchers.withId(R.id.mTvAddReminder)).perform(click());
        onView(withId(R.id.mEtAt)).check(matches(isDisplayed()));
        onView(withId(R.id.mEtAt)).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName()))).perform(PickerActions.setTime(11, 11));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.mBtnSave)).perform(click());
        Thread.sleep(1000);
        onView(withId(R.id.nav_view)).perform(click());
        Thread.sleep(2000);
        // if the one reminder is added successfully
        onView(withId(R.id.mRecyclerView)).check(matches(hasChildCount(1)));
        // check
        onView(withText("Cancel")).perform(click());
        Thread.sleep(1000);
        onView(withId(R.id.mRecyclerView)).check(matches(hasChildCount(0)));
    }


    @Test
    public void reminderTimeIsDisplayed(){
        onView(ViewMatchers.withId(R.id.mTvAddReminder)).perform(click());
        onView(withId(R.id.mEtMt)).check(matches(isDisplayed()));
        // set a time at arrival time, should automatically prompts a time displayed at reminder time
        onView(withId(R.id.mEtAt)).perform(click());
        // pick a picker, set it to 11:11, and check if it is working as intended
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName()))).perform(PickerActions.setTime(11, 11));
        onView(withText("OK")).perform(click());
        // no wait time should result in the same displayed time
        onView(withId(R.id.mEtMt)).check(matches(withText("11:11")));
    }

    @Test
    public void saveReminderIsDisplayed(){
        onView(ViewMatchers.withId(R.id.mTvAddReminder)).perform(click());
        onView(withId(R.id.mBtnSave)).check(matches(isDisplayed()));
    }

    @Test
    public void saveEmptyReminder(){
        onView(ViewMatchers.withId(R.id.mTvAddReminder)).perform(click());
        // reminder section should be empty
        onView(withId(R.id.mEtMt)).check(matches(withText("")));
        // save empty reminder
        onView(withId(R.id.mBtnSave)).perform(click());
        // should not be prompts to the next activity (should stay on current page)
        onView(withId(R.id.mBtnSave)).check(matches(isDisplayed()));
    }

    @Test
    public void cancelReminderIsDisplayed(){
        onView(ViewMatchers.withId(R.id.mTvAddReminder)).perform(click());
        onView(withId(R.id.mBtnCancel)).check(matches(isDisplayed()));
    }

    @Test
    public void cancelReminderSetting(){
        onView(ViewMatchers.withId(R.id.mTvAddReminder)).perform(click());
        // cancel button redirects back to the map view (home) page
        onView(withText("Cancel")).perform(click());
        onView(withId(R.id.nav_view)).check(matches(isDisplayed()));
    }
}