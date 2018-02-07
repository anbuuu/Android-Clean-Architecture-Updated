package com.projects.fairfaxchallenge;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.projects.fairfaxchallenge.presentation.view.activity.AppMainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Tests to handle item clicks
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityItemClickTest {

    @Rule
    public ActivityTestRule<AppMainActivity> mActivityRule =
            new ActivityTestRule<>(AppMainActivity.class);

    @Test
    public void onRecyclerItemClick() {
        onView(withId(R.id.rv_news_list_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));

    }


}
