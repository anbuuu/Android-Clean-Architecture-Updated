package com.projects.fairfaxchallenge.data;


import com.projects.fairfaxchallenge.data.net.DataService;
import com.projects.fairfaxchallenge.data.net.DataServiceImpl;
import com.projects.fairfaxchallenge.data.repository.DataRepository;
import com.projects.fairfaxchallenge.data.repository.source.DataSourceNet;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Modue that provides Service related collaborators
 */

@Module
public class DataModule {
    @Provides
    @Singleton
    DataService provideServiceApi() {
        return DataServiceImpl.getInstance();
    }

    @Provides
    DataSourceNet provideFairfaxDataSourceNet(DataService api) {
        return new DataSourceNet(api);
    }

    @Provides
    DataRepository provideFairfaxRepository(DataSourceNet fairfaxDataSourceNet) {
        return new DataRepository(fairfaxDataSourceNet);
    }

}
