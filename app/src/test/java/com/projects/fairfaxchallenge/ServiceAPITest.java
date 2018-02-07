package com.projects.fairfaxchallenge;

import com.projects.fairfaxchallenge.data.net.DataService;
import com.projects.fairfaxchallenge.data.net.DataServiceImpl;
import com.projects.fairfaxchallenge.domain.model.Example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.Collections;

import rx.Observable;
import rx.observers.TestSubscriber;

/**
 * Tests for connectivity and News List Results
 */

@RunWith(MockitoJUnitRunner.class)
public class ServiceAPITest {

    @Mock
    DataService dataService;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUsingTestSubscriber() throws Exception {
        TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
        Observable.just(1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(Collections.singletonList(1));
    }

    @Test
    public void fetchValidData() {
        TestSubscriber<Example> testSubscriber =
                TestSubscriber.create();
        DataServiceImpl.getInstance().getFairFaxExampleData().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
    }
}
