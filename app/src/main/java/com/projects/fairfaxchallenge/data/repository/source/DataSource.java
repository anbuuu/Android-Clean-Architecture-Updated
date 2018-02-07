package com.projects.fairfaxchallenge.data.repository.source;

import com.projects.fairfaxchallenge.domain.model.Example;

import rx.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 */

public interface DataSource {

    /**
     *  Retrieves an {@link Observable} which will emit {@link Example}
     */
    Observable<Example> fairfaxDataSource();
}
