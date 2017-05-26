package com.example.twitterteam.twitterclient.Activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.twitterteam.twitterclient.Fragment.ListFragment;
import com.example.twitterteam.twitterclient.Fragment.WebViewFragment;
import com.example.twitterteam.twitterclient.Model.Tweet;
import com.example.twitterteam.twitterclient.Model.TweetModel;
import com.example.twitterteam.twitterclient.Model.User;
import com.example.twitterteam.twitterclient.R;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity implements ListFragment.ListCallbacks {
    private InputStream is;
    private OAuth1RequestToken requestToken;
    private OAuth10aService service;
    private String authURL;
    public static final String AUTH_URL = "AUTH_URL";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        service = new ServiceBuilder()
//                .apiKey("TcNtue3KwrixI1s67W9U4NDCj")
//                .apiSecret("NuQrvuhg4Cb64GZxAvmAhPvesZRy1A39iQDdDdqYiGqhqsYGp7")
//                .build(TwitterApi.instance());
//
//        RequestAccess requestAccess = new RequestAccess();
//        requestAccess.execute(service);





        ReadJSON readJSON = new ReadJSON();
        readJSON.execute(getJSONString());




    }

    public String getJSONString() {
        String string = null;
        try {
            InputStream is = getAssets().open("output.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            string = new String(buffer, "UTF-8");
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
        return string;
    }

    @Override
    public void onListItemSelected(int position) {
        Intent intent = new Intent(this, UserDetailActivity.class);
        intent.putExtra(UserDetailActivity.EXTRA_POSITION, position);
        startActivity(intent);
    }

    public void replaceFragment() {

    }

    private class RequestAccess extends AsyncTask<OAuth10aService, Void, OAuth1RequestToken> {

        private InputStream params;
        private String JSONString;
        private final int firstValue = 0;

        @Override
        protected OAuth1RequestToken doInBackground(OAuth10aService... params) {
            OAuth1RequestToken requestToken = null;

            OAuth10aService service = params[0];
            try {
                requestToken = service.getRequestToken();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return requestToken;
        }

        @Override
        protected void onPostExecute(OAuth1RequestToken oAuth1RequestToken) {
            super.onPostExecute(oAuth1RequestToken);
            requestToken = oAuth1RequestToken;
            RequestAccess2 requestAccess2 = new RequestAccess2();
            requestAccess2.execute(requestToken);
        }
    }


    public class RequestAccess2 extends AsyncTask<OAuth1RequestToken, Void, String> {

        private InputStream params;
        private String JSONString;
        private final int firstValue = 0;

        @Override
        protected String doInBackground(OAuth1RequestToken... params) {
            OAuth1RequestToken requestToken1 = params[0];
            if (service != null) {
                String authUrl1 = service.getAuthorizationUrl(requestToken1);
                return authUrl1;

            } else {
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            authURL = s;
            Bundle b = new Bundle();
            b.putString(AUTH_URL, authURL);
            WebViewFragment webViewFragment = new WebViewFragment();
            webViewFragment.setArguments(b);
            getSupportFragmentManager().beginTransaction().replace(R.id.mainFragmentContainer, webViewFragment).commit();
        }
    }

    private class ReadJSON extends AsyncTask<String, Void, Void> {

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
            String userBackgroundHexCode;
            String userProfileBackgroundImageURL;
            String userImageURL;
            String userProfileBannerURL;


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
                    userBackgroundHexCode = userObject.getString("profile_background_color");
                    userProfileBackgroundImageURL = userObject.getString("profile_background_image_url");
                    userImageURL = userObject.getString("profile_image_url");
                    try {
                        userProfileBannerURL = userObject.getString("profile_banner_url");
                    }catch(JSONException jsonEx){
                        userProfileBannerURL = "no img";
                    }

                    user = new User(userID, userIDString, userName, userScreenName, userLocation, userDescription, userUrl, userCreatedAt, userFollowerCount, userFollowingCount, userTweetCount, userLikeCount, userBackgroundHexCode, userProfileBackgroundImageURL, userImageURL, userProfileBannerURL);
                    tweet = new Tweet(tweetCreatedAt, tweetId, tweetIdString, tweetText, user, retweets, likes);
                    TweetModel.getInstance().addTweet(tweet);
                }
            } catch (JSONException jsonEx) {
                jsonEx.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ListFragment listFragment = new ListFragment();

            getFragmentManager().beginTransaction().replace(R.id.mainFragmentContainer, listFragment).commit();
        }
    }

}



