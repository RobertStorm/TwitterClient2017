package com.example.twitterteam.twitterclient.Fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.twitterteam.twitterclient.Model.TweetModel;
import com.example.twitterteam.twitterclient.R;
import com.example.twitterteam.twitterclient.View.TweetAdapter;

/**
 * Created by Robert on 3-5-2017.
 */

public class ListFragment extends Fragment {
    private ListCallbacks listener;
    private ListView listView;
    private TweetAdapter tweetAdapter;

    public ListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        tweetAdapter = new TweetAdapter(getContext());

        listView = (ListView) rootView.findViewById(R.id.lv_tweets);
        listView.setAdapter(tweetAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(listener != null){
                    listener.onListItemSelected(position);
                }
            }
        });
        return rootView;
    }

    public interface ListCallbacks {
        void onListItemSelected(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ListCallbacks) {
            this.listener = (ListCallbacks) context;
        } else {
            throw new ClassCastException("ListCallbacks instance expected");
        }
    }
}
