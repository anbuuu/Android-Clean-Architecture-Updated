package com.projects.fairfaxchallenge;

import android.test.ApplicationTestCase;

@SuppressWarnings("deprecation")
public class ApplicationTest extends ApplicationTestCase<MainApplication> {

    public ApplicationTest() {
        super(MainApplication.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        createApplication();
        MainApplication application = getApplication();

    }


}