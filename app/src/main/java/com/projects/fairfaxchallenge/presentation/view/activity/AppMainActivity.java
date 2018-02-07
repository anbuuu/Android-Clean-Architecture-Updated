package com.projects.fairfaxchallenge.presentation.view.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.projects.fairfaxchallenge.MainApplication;
import com.projects.fairfaxchallenge.R;
import com.projects.fairfaxchallenge.domain.model.Asset;
import com.projects.fairfaxchallenge.presentation.events.EventFragment;
import com.projects.fairfaxchallenge.presentation.view.fragment.NewsDetailWebViewFragment;
import com.projects.fairfaxchallenge.presentation.view.fragment.NewsListFragment;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Main Application Screen. This is the app entry point
 */

public class AppMainActivity extends AppCompatActivity {

    private Subscription busSubscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!isTablet()) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    /*
      Create the Fragment
    */
        if (savedInstanceState == null) {
            Fragment categoryListFragment = new NewsListFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction
                    .add(R.id.fragmentContainer, categoryListFragment,
                            getResources().getString(R.string.assetListFragment))
                    .commit();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        autoUnsubBus();
    }

    private void handlerBus(@NonNull Object o) {
        if (o instanceof EventFragment) {
            EventFragment event = (EventFragment) o;
            if (null != event.getAssetData()) {
                openItemDetail(event.getAssetData());
            }
        }
    }

    private void openItemDetail(Asset assetData) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(getResources().getString(R.string.itemData), assetData.getUrl());
        Fragment itemDetailFragment = new NewsDetailWebViewFragment();
        itemDetailFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fragment_right_enter,
                R.anim.stay, R.anim.stay, R.anim.exit_animation);
        fragmentTransaction
                .replace(R.id.fragmentContainer, itemDetailFragment,
                        getResources().getString(R.string.itemDetailFragment))
                .addToBackStack(null)
                .commit();

    }

    private void autoUnsubBus() {
        if (busSubscription != null && !busSubscription.isUnsubscribed()) {
            busSubscription.unsubscribe();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        autoUnsubBus();
        busSubscription = MainApplication.get().bus().toObserverable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Action1<Object>() {
                            @Override
                            public void call(Object o) {
                                if (o == null) return;
                                handlerBus(o);
                            }
                        }
                );
    }

    private boolean isTablet() {
        return getResources().getBoolean(R.bool.is_tablet);
    }

}
