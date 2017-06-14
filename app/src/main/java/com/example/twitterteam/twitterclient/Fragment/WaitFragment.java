package com.example.twitterteam.twitterclient.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.twitterteam.twitterclient.R;
import com.example.twitterteam.twitterclient.View.TweetAdapter;

import static com.example.twitterteam.twitterclient.Activity.MainActivity.AUTH_URL;

/**
 * Created by Robert on 24-5-2017.
 */

public class WebViewFragment extends Fragment {
    private ListFragment.ListCallbacks listener;
    private ListView listView;
    private TweetAdapter tweetAdapter;
    private String authURL;
    private WebView webView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_webview, container, false);

        if (getArguments() != null) {
            authURL = getArguments().getString(AUTH_URL);
        }

        webView = (WebView) rootView.findViewById(R.id.wv_authorize);
        webView.loadUrl(authURL);
//        webView.loadUrl("www.google.com");



        return rootView;
    }

}

