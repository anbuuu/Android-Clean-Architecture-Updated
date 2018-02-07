package com.projects.fairfaxchallenge.data.net;

import com.projects.fairfaxchallenge.domain.model.Example;

import retrofit2.http.GET;
import rx.Observable;


/**
 * RestApi for retrieving data from the network.
 */

public interface DataService {

    /**
     * Retrieves an {@link Observable} which will emit a {@link Example}.
     */
    @GET(".")
    Observable<Example> getFairFaxExampleData();
}
