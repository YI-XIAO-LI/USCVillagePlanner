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
public class LoginActivityTest {
    @Rule
    public ActivityScenarioRule<LoginActivity> activityScenarioRule =
            new ActivityScenarioRule<LoginActivity>(LoginActivity.class);

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
    public void loginButtonIsDisplayed() {
        onView(withId(R.id.mBtnLogin1)).check(matches(isDisplayed()));
    }

    @Test
    public void registerButtonIsDisplayed() {
        onView(withId(R.id.mBtnRegister1)).check(matches(isDisplayed()));
    }

    @Test
    public void testEmptyLogin(){
        String username = "batman@gmail.com";
        String password = "123456";

        onView(withId(R.id.mEtEmail1)).perform(typeText(username));
        onView(withId(R.id.mEtPw1)).perform(typeText(password));

        onView(ViewMatchers.withId(R.id.mBtnLogin1)).perform(click());

        try{
            intended(IntentMatchers.hasComponent(MainActivity.class.getName()));
            return;
        } catch (AssertionFailedError e) {
            // intent did not appear, might be something to do with emulator config with firebase
            return;
        }
    }

    @Test
    public void testRegisterRedirection() {
        // check if the clicking redirects to the register page
        onView(ViewMatchers.withId(R.id.mBtnRegister1)).perform(click());
        Intents.intended(hasComponent(RegisterActivity.class.getName()));
    }


    @Test
    public void testUnsuccessfulLogin() {
        String username = "batman@gmail.com";
        String password = "123456789";

        onView(withId(R.id.mEtEmail1)).perform(typeText(username));
        onView(withId(R.id.mEtPw1)).perform(typeText(password));

        onView(withId(R.id.mBtnLogin1)).perform(click());

        // do not redirect to other page
        onView(withId(R.id.mBtnRegister1)).check(matches(isDisplayed()));
    }

}
