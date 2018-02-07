package com.projects.fairfaxchallenge.presentation.view.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.projects.fairfaxchallenge.R;
import com.projects.fairfaxchallenge.presentation.utils.WebViewUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Fragment to Show the Web view for the Selected News Article
 */

public class NewsDetailWebViewFragment extends Fragment {

    private String newsDetailedWebUrl;
    private final String TAG = NewsDetailWebViewFragment.class.getSimpleName();

    @BindView(R.id.webview_news_detail)
    WebView webview_news_detail;

    @BindView(R.id.loading_webview)
    ProgressBar pb_loading_webview;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        // Retrieve the URL
        newsDetailedWebUrl = (String) getArguments().getSerializable("itemData");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "Current URL  1[" + newsDetailedWebUrl + "]");
        if (null != newsDetailedWebUrl) {
            webview_news_detail.setWebViewClient(new NewsWebViewClient());

            // Disable File Access, Geo Location and Javascript
            WebViewUtil.disableRiskySettings(webview_news_detail);

            webview_news_detail.loadUrl(newsDetailedWebUrl);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.news_detailed_webview, container, false);
        ButterKnife.bind(this, v);
        return v;

    }

    private class NewsWebViewClient extends WebViewClient {

        private NewsWebViewClient() {
            super();
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            pb_loading_webview.setVisibility(View.VISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return isValidHost(url);
        }

        private boolean isValidHost(String url) {
            return TextUtils.isEmpty(url);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            pb_loading_webview.setVisibility(View.GONE);
        }


    }
}
