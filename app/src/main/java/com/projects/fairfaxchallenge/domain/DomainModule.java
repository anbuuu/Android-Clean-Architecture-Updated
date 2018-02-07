package com.projects.fairfaxchallenge.domain;

import com.projects.fairfaxchallenge.data.repository.DataRepository;
import com.projects.fairfaxchallenge.domain.interactor.InteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Module to provide Interactor to Outer Layer
 */

@Module
public class DomainModule {

    @Provides
    InteractorImpl provideFairfaxDataInteractory(DataRepository fairfaxRepository) {
        return new InteractorImpl(fairfaxRepository);
    }

}
