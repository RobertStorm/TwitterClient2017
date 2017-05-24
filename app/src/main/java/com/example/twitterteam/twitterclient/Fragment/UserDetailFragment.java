package com.example.twitterteam.twitterclient.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.twitterteam.twitterclient.Model.TweetModel;
import com.example.twitterteam.twitterclient.R;
import com.example.twitterteam.twitterclient.View.TweetAdapter;

/**
 * Created by Robert on 17-5-2017.
 */

public class UserDetailFragment extends Fragment {
    private ListView listView;
    private TweetAdapter tweetAdapter;

    public UserDetailFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_userdetail, container, false);



        return rootView;
    }
}
