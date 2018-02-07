package com.projects.fairfaxchallenge.data.repository;

import com.projects.fairfaxchallenge.data.repository.source.DataSource;
import com.projects.fairfaxchallenge.data.repository.source.DataSourceNet;
import com.projects.fairfaxchallenge.domain.model.Example;

import javax.inject.Inject;

import rx.Observable;

/**
 * {@link DataRepository} for retrieving News Items
 */

public class DataRepository {

    private DataSource fairfaxDataSourceNet;

    /**
     * Constructs a {@link DataRepository}
     *
     * @param fairfaxDataSource
     */
    @Inject
    public DataRepository(DataSourceNet fairfaxDataSource) {
        this.fairfaxDataSourceNet = fairfaxDataSource;
    }

    public Observable<Example> getFairfaxResponse() {
        return fairfaxDataSourceNet.fairfaxDataSource();
    }
}
