package com.projects.fairfaxchallenge;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.projects.fairfaxchallenge.presentation.events.RxEventBus;

/**
 * Created by anbusubramanian on 29/1/18.
 */

public class MainApplication extends Application {


    private static ComponentApplication componentApplication;
    private static MainApplication instance;
    private RxEventBus rxBus;

    @Override
    public void onCreate() {
        super.onCreate();
        componentApplication = DaggerComponentApplication.builder().build();
        instance = this;
        rxBus = new RxEventBus();
        Stetho.initializeWithDefaults(this);
    }

    public static MainApplication get() {
        return instance;
    }

    public RxEventBus bus() {
        return rxBus;
    }

    public static ComponentApplication component() {
        return componentApplication;
    }
}
