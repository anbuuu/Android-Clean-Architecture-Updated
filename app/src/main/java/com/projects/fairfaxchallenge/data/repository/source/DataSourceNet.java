package com.projects.fairfaxchallenge.data.repository.source;

import com.projects.fairfaxchallenge.data.net.DataService;
import com.projects.fairfaxchallenge.domain.model.Example;

import javax.inject.Inject;

import rx.Observable;

/**
 * {@link DataSource} Implementation
 */

public class DataSourceNet implements DataSource {

    private DataService api;

    @Inject
    public DataSourceNet(DataService api) {
        this.api = api;
    }

    @Override
    public Observable<Example> fairfaxDataSource() {
        return this.api.getFairFaxExampleData();
    }
}
