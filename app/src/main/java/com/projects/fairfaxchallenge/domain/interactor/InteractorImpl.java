package com.projects.fairfaxchallenge.domain.interactor;

import com.projects.fairfaxchallenge.data.repository.DataRepository;
import com.projects.fairfaxchallenge.domain.model.Example;

import javax.inject.Inject;

import rx.Observable;

/**
 * This class is an implementation of {@link Interactor} that represents a use case for
 * retrieving a collection of all {@link Example}
 */
public class InteractorImpl extends Interactor<Example, Void> {

    private DataRepository mDataRepository;

    @Inject
    public InteractorImpl(DataRepository dataRepository) {
        this.mDataRepository = dataRepository;
    }


    @Override
    protected Observable<Example> createObservable(Void aVoid) {
        return this.mDataRepository.getFairfaxResponse();
    }
}
