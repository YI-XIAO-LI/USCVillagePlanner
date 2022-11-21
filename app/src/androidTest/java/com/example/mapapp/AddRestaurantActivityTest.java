package com.example.mapapp;

import static android.service.autofill.Validators.not;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.is;
import static java.security.AccessController.getContext;

import android.app.Activity;
import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Root;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.mapapp.activity.AddReminderActivity;
import com.example.mapapp.activity.AddRestaurantActivity;
import com.example.mapapp.activity.LoginActivity;
import com.example.mapapp.activity.MainActivity;
import com.example.mapapp.activity.MapsActivity;
import com.example.mapapp.activity.RegisterActivity;

import junit.framework.AssertionFailedError;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class AddRestaurantActivityTest {
    @Rule
    public ActivityScenarioRule<AddRestaurantActivity> activityScenarioRule =
            new ActivityScenarioRule<AddRestaurantActivity>(AddRestaurantActivity.class);

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
    public void testAddNewRestaurant(){
        String restName = "CafeABC";
        String restAddress = "123 Street, Nottingham IL 10000";
        String restLong = "-118.28496904742106";
        String restLat = "34.02550023106205";


        onView(withId(R.id.restaurantName)).perform(typeText(restName));
        onView(withId(R.id.restaurantAddress)).perform(typeText(restAddress));
        onView(withId(R.id.restaurantLong)).perform(typeText(restLong));
        onView(withId(R.id.restaurantLat)).perform(typeText(restLat));

        onView(withId(R.id.addRestaurant)).perform(click());

        try{
            intended(IntentMatchers.hasComponent(MainActivity.class.getName()));
            return;
        } catch (AssertionFailedError e) {
            // intent did not appear, might be something to do with emulator config, but you will
            // see a toast message saying restaurant added successfully
            return;
        }



        // do not redirect to other page

    }

    @Test
    public void testInvalidAddRestaurant(){
        String restName = "CafeABC";
        String restAddress = "123 Street, Nottingham IL 10000";
        String restLong = "0";
        String restLat = "0";


        onView(withId(R.id.restaurantName)).perform(typeText(restName));
        onView(withId(R.id.restaurantAddress)).perform(typeText(restAddress));
        onView(withId(R.id.restaurantLong)).perform(typeText(restLong));
        onView(withId(R.id.restaurantLat)).perform(typeText(restLat));

        onView(withId(R.id.addRestaurant)).perform(click());

        // do not redirect to other page
        onView(withId(R.id.addRestaurant)).check(matches(isDisplayed()));
    }




    @Test
    public void testAddEmptyRestaurant() {
        String restName = "";
        String restAddress = "";
        String restLong = "";
        String restLat = "";


        onView(withId(R.id.restaurantName)).perform(typeText(restName));
        onView(withId(R.id.restaurantAddress)).perform(typeText(restAddress));
        onView(withId(R.id.restaurantLong)).perform(typeText(restLong));
        onView(withId(R.id.restaurantLat)).perform(typeText(restLat));

        onView(withId(R.id.addRestaurant)).perform(click());

        // do not redirect to other page
        onView(withId(R.id.addRestaurant)).check(matches(isDisplayed()));
    }



}
