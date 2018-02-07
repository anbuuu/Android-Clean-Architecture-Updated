package com.projects.fairfaxchallenge.presentation;

import com.projects.fairfaxchallenge.domain.interactor.InteractorImpl;
import com.projects.fairfaxchallenge.presentation.presenter.PresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by anbusubramanian on 29/1/18.
 */

@Module
public class PresentationModule {

    @Provides
    public PresenterImpl provideExamples(InteractorImpl interactorImpl) {
        return new PresenterImpl(interactorImpl);
    }
}
