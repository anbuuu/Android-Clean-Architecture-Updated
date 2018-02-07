package com.projects.fairfaxchallenge.presentation.view;

import com.projects.fairfaxchallenge.domain.model.Example;
import com.projects.fairfaxchallenge.presentation.view.shared.LoadingView;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a list of {@link Example}.
 */

public interface ResultsView extends LoadingView {

    void onExampleLoaded(Example example);

    void onExampleLoadedError();

}
