package com.projects.fairfaxchallenge.presentation.utils;

import android.webkit.WebView;

/**
 * Created by anbusubramanian on 5/2/18.
 */

public class WebViewUtil {
    public static void disableRiskySettings(WebView webView) {
        // Disable Java Script
        webView.getSettings().setJavaScriptEnabled(false);
        // Disable File Access
        webView.getSettings().setAllowFileAccess(false);
        // Disable Geo Location API
        webView.getSettings().setGeolocationEnabled(false);

    }

}