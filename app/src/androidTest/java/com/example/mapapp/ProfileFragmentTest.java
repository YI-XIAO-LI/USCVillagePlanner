package com.example.mapapp;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.containsString;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.action.CoordinatesProvider;
import androidx.test.espresso.action.GeneralClickAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Tap;
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
import com.example.mapapp.activity.RegisterActivity;

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
    public void userEmailIsDisplayed(){
        // check if email is displayed correctly, need to run login test first
        onView(ViewMatchers.withId(R.id.nav_view)).perform(clickPercent(0.9F, 0.9F));
        onView(withId(R.id.mTvEmail)).check(matches(isDisplayed()));
        onView(withId(R.id.mTvEmail)).check(matches(withText(containsString("@"))));
    }

    @Test
    public void userNameIsDisplayed(){
        // check if name is displayed correctly need to run login test first
        onView(ViewMatchers.withId(R.id.nav_view)).perform(clickPercent(0.9F, 0.9F));
        // onView(ViewMatchers.withId(R.id.nav_view)).perform(click());
        onView(withId(R.id.mTvName)).check(matches(isDisplayed()));
    }

    @Test
    public void userProfilePhotoDisplayed() {
        onView(ViewMatchers.withId(R.id.nav_view)).perform(clickPercent(0.9F, 0.9F));
        // onView(ViewMatchers.withId(R.id.nav_view)).perform(click());
        onView(withId(R.id.mIvHead)).check(matches(isDisplayed()));
    }

    @Test
    public void logoutButtonRedirectingSuccessful(){
        onView(ViewMatchers.withId(R.id.nav_view)).perform(clickPercent(0.9F, 0.9F));
        // onView(ViewMatchers.withId(R.id.nav_view)).perform(click());
        onView(withId(R.id.logout)).perform(click());
        Intents.intended(hasComponent(LoginActivity.class.getName()));

    }

    public static ViewAction clickPercent(final float pctX, final float pctY){
        return new GeneralClickAction(
                Tap.SINGLE,
                new CoordinatesProvider() {
                    @Override
                    public float[] calculateCoordinates(View view) {

                        final int[] screenPos = new int[2];
                        view.getLocationOnScreen(screenPos);
                        int w = view.getWidth();
                        int h = view.getHeight();

                        float x = w * pctX;
                        float y = h * pctY;

                        final float screenX = screenPos[0] + x;
                        final float screenY = screenPos[1] + y;
                        float[] coordinates = {screenX, screenY};

                        return coordinates;
                    }
                },
                Press.FINGER);
    }

}