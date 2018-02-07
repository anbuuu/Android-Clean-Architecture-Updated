package com.projects.fairfaxchallenge;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.projects.fairfaxchallenge.presentation.view.activity.AppMainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.web.sugar.Web.onWebView;


/**
 * Main Activity Item Fields Test
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ActivityFieldTest {

    @Rule
    public ActivityTestRule<AppMainActivity> mActivityRule = new ActivityTestRule(AppMainActivity.class);

    @Before
    public void setup() {
        //enable javascript for web page to perform web interactions
        onWebView().forceJavascriptEnabled();
    }

    @Test
    public void scrollToRecyclerViewItem() {
        onView(withId(R.id.rv_news_list_view)).perform(RecyclerViewActions.scrollToPosition(0));
    }

}
