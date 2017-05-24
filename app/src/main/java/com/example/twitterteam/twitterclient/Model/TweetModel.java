package com.example.twitterteam.twitterclient.Model;

import com.example.twitterteam.twitterclient.Activity.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.DatagramChannel;
import java.util.ArrayList;


/**
 * Created by Robert on 3-5-2017.
 */

public class TweetModel {

    private static TweetModel instance = null;
    private ArrayList<Tweet> tweets = new ArrayList<>();

    public static TweetModel getInstance() {
        if (instance == null) {
            instance = new TweetModel();

        }

        return instance;
    }

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
    }

    public ArrayList<Tweet> getTweets() {
        return tweets;
    }
}
