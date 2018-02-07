package com.projects.fairfaxchallenge.presentation.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.projects.fairfaxchallenge.MainApplication;
import com.projects.fairfaxchallenge.R;
import com.projects.fairfaxchallenge.domain.model.Asset;
import com.projects.fairfaxchallenge.domain.model.Example;
import com.projects.fairfaxchallenge.presentation.presenter.PresenterImpl;
import com.projects.fairfaxchallenge.presentation.view.ResultsView;
import com.projects.fairfaxchallenge.presentation.view.adapter.NewsListDataAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.annotation.Nullable;
import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Fragment that shows a list of News Articles
 */

public class NewsListFragment extends Fragment
        implements ResultsView,
        SwipeRefreshLayout.OnRefreshListener {

    @Inject
    PresenterImpl mPresenterImpl;

    @BindView(R.id.rv_news_list_view)
    RecyclerView asset_rv;

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    private LinearLayoutManager mLayoutManager;
    private ArrayList<Asset> mAssetArrayList;
    private View rootView;
    private static final String TAG = NewsListFragment.class.getSimpleName();

    private NewsListDataAdapter mAssetListDataAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setRetainInstance(true);
        MainApplication.component().inject(this);
        mAssetArrayList = new ArrayList<>();
        // Vertical Adapter
        mAssetListDataAdapter = new NewsListDataAdapter(getActivity().getApplicationContext(), mAssetArrayList);
    }


    @android.support.annotation.Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @android.support.annotation.Nullable ViewGroup container, @android.support.annotation.Nullable Bundle savedInstanceState) {
        return getView() != null ? getView() : inflater.inflate
                (R.layout.fragment_main_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @android.support.annotation.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        mRefreshLayout.setOnRefreshListener(this);
        asset_rv.setAdapter(mAssetListDataAdapter);
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        asset_rv.setLayoutManager(mLayoutManager);
        asset_rv.setSaveEnabled(true);
        mPresenterImpl.bind(this);
        if (savedInstanceState == null) {
            mPresenterImpl.loadAssetList();
        }
    }

    @Override
    public void onRefresh() {
        mPresenterImpl.loadAssetList();
    }

    @Override
    public void showLoading() {
        mRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        mRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onExampleLoaded(Example example) {
        Collections.sort(example.getAssets(), new Comparator<Asset>() {
            @Override
            public int compare(Asset o1, Asset o2) {
                return o1.getTimeStamp().compareTo(o2.getTimeStamp());
            }
        });
        mAssetArrayList.clear();
        mAssetArrayList.addAll(example.getAssets());
        mAssetListDataAdapter.notifyDataSetChanged();
    }

    @Override
    public void onExampleLoadedError() {
        Toast.makeText(getContext(), getResources().getString(R.string.defaultErrorMsg),
                Toast.LENGTH_LONG).show();

    }


}
