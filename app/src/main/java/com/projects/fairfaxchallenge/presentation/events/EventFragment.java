package com.projects.fairfaxchallenge.presentation.events;

import com.projects.fairfaxchallenge.domain.model.Asset;

/**
 * Class to capture the new Fragment Event
 */

public class EventFragment {

    private Asset assetData;

    public Asset getAssetData() {
        return assetData;
    }

    public EventFragment(Asset onClickData) {
        assetData = onClickData;

    }

}
