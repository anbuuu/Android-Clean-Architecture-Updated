package com.projects.fairfaxchallenge.presentation.presenter;

import android.util.Log;

import com.projects.fairfaxchallenge.domain.interactor.InteractorImpl;
import com.projects.fairfaxchallenge.domain.model.Example;
import com.projects.fairfaxchallenge.presentation.presenter.shared.Presenter;
import com.projects.fairfaxchallenge.presentation.view.ResultsView;

import rx.Subscriber;


/**
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */

public class PresenterImpl implements Presenter<ResultsView> {

    private final InteractorImpl acmeInteractor;
    private ResultsView view;
    private final String TAG = PresenterImpl.class.getSimpleName();

    public PresenterImpl(InteractorImpl acmeInteractor) {
        this.acmeInteractor = acmeInteractor;
    }

    /**
     * Load all Assets
     */
    public void loadAssetList() {
        view.showLoading();
        getNewsItems(new Subscriber<Example>() {
            @Override
            public void onCompleted() {
                view.hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "Exception thrown while loading list " + e.getMessage());
                view.hideLoading();
                view.onExampleLoadedError();
            }

            @Override
            public void onNext(Example example) {
                view.onExampleLoaded(example);
            }
        });

    }

    /**
     * Retrieves Get Categories List Subscriber
     *
     * @param subscriber
     */
    private void getNewsItems(Subscriber<Example> subscriber) {
        this.acmeInteractor.execute(null, subscriber);
    }

    @Override
    public void bind(ResultsView view) {
        this.view = view;
    }

}
