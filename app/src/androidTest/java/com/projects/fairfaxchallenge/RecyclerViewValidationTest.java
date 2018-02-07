package com.projects.fairfaxchallenge;

import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.projects.fairfaxchallenge.presentation.view.activity.AppMainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Test to ensure Fragment view is present
 */

@MediumTest
@RunWith(AndroidJUnit4.class)
public class RecyclerViewValidationTest {

    @Rule
    public ActivityTestRule<AppMainActivity> rule =
            new ActivityTestRule<>(AppMainActivity.class);

    @Test
    public void ensureFragmentViewIsPresent() throws Exception {
        AppMainActivity activity = rule.getActivity();
        View viewbyId = activity.findViewById(R.id.fragmentContainer);
        assertThat(viewbyId, notNullValue());
        View verticalRecyclerViewId = activity.findViewById(R.id.rv_news_list_view);
        assertThat(verticalRecyclerViewId, notNullValue());
        assertThat(verticalRecyclerViewId, instanceOf(RecyclerView.class));

    }

}
