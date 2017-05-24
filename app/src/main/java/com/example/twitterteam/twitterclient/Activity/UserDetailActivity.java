package com.example.twitterteam.twitterclient.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.twitterteam.twitterclient.Model.Tweet;
import com.example.twitterteam.twitterclient.Model.TweetModel;
import com.example.twitterteam.twitterclient.Model.User;
import com.example.twitterteam.twitterclient.R;

public class UserDetailActivity extends AppCompatActivity {

    private ImageView iv_userBackground;
    private ImageView iv_userPicture;
    private TextView tv_userName;
    private TextView tv_screenName;
    private TextView tv_tweets;
    private TextView tv_followers;
    private TextView tv_following;
    private TextView tv_description;

    public static final String EXTRA_POSITION = "position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_userdetail);

        Intent intent = getIntent();
        int position = intent.getIntExtra(EXTRA_POSITION, -1);

        Tweet tweet = TweetModel.getInstance().getTweets().get(position);
        User user = tweet.getTweep();

        String username = user.getName();

//        iv_userBackground = (ImageView) findViewById(R.id.iv_detail_userBackground);
//        iv_userPicture = (ImageView) findViewById(R.id.iv_detail_userPicture);
        tv_userName = (TextView) findViewById(R.id.tv_detail_username);
        tv_screenName = (TextView) findViewById(R.id.tv_detail_screenname);
        tv_tweets = (TextView) findViewById(R.id.tv_detail_tweets);
        tv_followers = (TextView) findViewById(R.id.tv_detail_followers);
        tv_following = (TextView) findViewById(R.id.tv_detail_following);
        tv_description = (TextView) findViewById(R.id.tv_detail_description);

        tv_userName.setText(user.getName() + "");
//        tv_screenName.setText(user.getScreenName() + "");
        tv_tweets.setText(user.getTweetCount() + "");
        tv_followers.setText(user.getFollowerCount() + "");
        tv_following.setText(user.getFollowingCount() + "");
        tv_description.setText(user.getDescription() + "");

    }
}
