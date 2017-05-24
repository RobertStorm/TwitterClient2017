package com.example.twitterteam.twitterclient.Task;

import android.os.AsyncTask;

import com.example.twitterteam.twitterclient.Model.Tweet;
import com.example.twitterteam.twitterclient.Model.TweetModel;
import com.example.twitterteam.twitterclient.Model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Robert on 17-5-2017.
 */

public class ReadJSON extends AsyncTask<String, Void, Void> {

    private InputStream params;
    private String JSONString;
    private final int firstValue = 0;

    @Override
    protected Void doInBackground(String... params) {

        this.JSONString = params[firstValue];

        Tweet tweet;
        User user = null;

        //GEGEVENS TWEET:
        String tweetCreatedAt;
        long tweetId;
        String tweetIdString;
        String tweetText;
        User tweetTweep;
        int retweets;
        int likes;

        //GEGEVENS USER:
        long userID;
        String userIDString;
        String userName;
        String userScreenName;
        String userLocation;
        String userDescription;
        String userUrl;
        String userCreatedAt;
        int userFollowerCount;
        int userFollowingCount;
        int userTweetCount;
        int userLikeCount;


        try {
            JSONObject jsonObject = new JSONObject(JSONString);
            JSONArray statusesArray = jsonObject.getJSONArray("statuses");

            for (int i = 0; i < statusesArray.length(); i++) {

                JSONObject jsonObjectStatus = statusesArray.getJSONObject(i);
                tweetCreatedAt = jsonObjectStatus.getString("created_at");
                tweetId = jsonObjectStatus.getInt("id");
                tweetIdString = jsonObjectStatus.getString("id_str");
                retweets = jsonObjectStatus.getInt("retweet_count");
                likes = jsonObjectStatus.getInt("favorite_count");
                tweetText = jsonObjectStatus.getString("text");

                //GET USER
                JSONObject tweetObject = statusesArray.getJSONObject(i);
                JSONObject userObject = tweetObject.getJSONObject("user");

                userID = userObject.getInt("id");
                userIDString = userObject.getString("id_str");
                userName = userObject.getString("name");
                userScreenName = userObject.getString("screen_name");
                userLocation = userObject.getString("location");
                userDescription = userObject.getString("description");
                userUrl = userObject.getString("url");
                userCreatedAt = userObject.getString("created_at");
                userFollowerCount = userObject.getInt("followers_count");
                userFollowingCount = userObject.getInt("friends_count");
                userTweetCount = userObject.getInt("statuses_count");
                userLikeCount = userObject.getInt("favourites_count");

                user = new User(userID, userIDString, userName, userScreenName, userLocation, userDescription, userUrl, userCreatedAt, userFollowerCount, userFollowingCount, userTweetCount, userLikeCount);
                tweet = new Tweet(tweetCreatedAt, tweetId, tweetIdString, tweetText, user, retweets, likes);
                TweetModel.getInstance().addTweet(tweet);
            }
        } catch (JSONException jsonEx) {
            jsonEx.printStackTrace();
        }

        return null;
    }
}
