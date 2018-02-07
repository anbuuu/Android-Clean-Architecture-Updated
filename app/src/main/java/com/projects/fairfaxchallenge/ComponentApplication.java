package com.projects.fairfaxchallenge;


import com.projects.fairfaxchallenge.data.DataModule;
import com.projects.fairfaxchallenge.domain.DomainModule;
import com.projects.fairfaxchallenge.presentation.PresentationModule;
import com.projects.fairfaxchallenge.presentation.view.fragment.NewsListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Dagger Component Injection
 */
@Singleton
@Component(modules = {
        DataModule.class,
        DomainModule.class,
        PresentationModule.class
})
public interface ComponentApplication {
    void inject(NewsListFragment host);
}
