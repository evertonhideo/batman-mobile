package com.example.hackathonapp.common;

import android.app.Activity;

import androidx.annotation.IdRes;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.allOf;


@SuppressWarnings("unchecked")

public abstract class ScreenRobot<T extends ScreenRobot> {

    private Activity activityContext;

    public static <T extends ScreenRobot> T withRobot(Class<T> screenRobotClass) {
        if (screenRobotClass == null) {
            throw new IllegalArgumentException("instance class == null");
        }

        try {
            return screenRobotClass.newInstance();
        } catch (IllegalAccessException iae) {
            throw new RuntimeException("IllegalAccessException", iae);
        } catch (InstantiationException ie) {
            throw new RuntimeException("InstantiationException", ie);
        }
    }

    public T sleep(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000L);
        return (T) this;
    }


//Ações de validação


    public T enterTextIntoView(@IdRes int viewId, String text) {
        onView(withId(viewId)).perform(typeText(text));
        closeKeyboard();
        return (T) this;
    }


    public T checkIdHasText(@IdRes int viewId, final String text) {
        onView(allOf(withId(viewId), withText(text))).check(matches(withText(text)));
        return (T) this;
    }

    public T checkViewContainsText(String text) {
        onView(allOf(withText(text))).check(matches(isDisplayed()));
        return (T) this;
    }

    public T checkTextIsDisplayed(@IdRes int viewId, final String text) {
        onView(allOf(withId(viewId))).check(matches(withText(text)));
        return (T) this;
    }


//    public T checkIsDisplayed(@IdRes int viewIds) {
//        for (int viewId : viewIds) {
//            onView(withId(viewId)).check(matches(isDisplayed()));
//        }
//        return (T) this;
//    }

//    public T checkDoesNotExist(@IdRes int viewIds) {
//        for (int viewId : viewIds) {
//            onView(withId(viewId)).check(doesNotExist());
//        }
//        return (T) this;
//    }


//Ações com click

    public T clickOnIdWithText(@IdRes int viewId, final String text) {
        onView(allOf(withId(viewId), withText(text))).perform(click());
        return (T) this;
    }

    public T clickOnListWithText(final String text) {
        onView(allOf(withText(text), isDisplayed())).perform(click());
        return (T) this;
    }

    public T clickOnId(@IdRes int viewId) {
        onView(allOf(withId(viewId), isDisplayed())).perform(click());
        return (T) this;
    }

    public T clickOnTextWithPartialMatch(final String text) {
        onView(allOf(withText(containsString(text)))).perform(click());
        return (T) this;
    }


// Ações dos componentes nativos


    public T closeKeyboard() {
        Espresso.closeSoftKeyboard();
        return (T) this;
    }

    public T scrollViewDown(@IdRes int viewIds) {
        onView(withId(viewIds)).perform(swipeUp());
        return (T) this;
    }

    public T scrollViewUp(@IdRes int viewIds) {
        onView(withId(viewIds)).perform(swipeDown(), click());
        return (T) this;
    }

    public T swipeLeftOnView(@IdRes int viewId) {
        onView(allOf(withId(viewId))).perform(swipeLeft());
        return (T) this;
    }

    public T swipeRightOnView(@IdRes int viewId) {
        onView(withId(viewId)).perform(swipeRight());
        return (T) this;
    }

    public T clickOnBackButton(@IdRes int viewId) {
        onView(allOf(ViewMatchers.withId(viewId), isDisplayed())).perform(click());
        return (T) this;
    }

    public T pressBack() {
        Espresso.pressBack();
        return (T) this;
    }

}

