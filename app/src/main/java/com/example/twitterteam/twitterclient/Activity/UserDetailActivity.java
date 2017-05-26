package com.example.twitterteam.twitterclient.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.twitterteam.twitterclient.Model.Tweet;
import com.example.twitterteam.twitterclient.Model.TweetModel;
import com.example.twitterteam.twitterclient.Model.User;
import com.example.twitterteam.twitterclient.R;

public class UserDetailActivity extends AppCompatActivity {

    private ImageView iv_userBanner;
    private ImageView iv_userPicture;
    private TextView tv_userName;
    private TextView tv_screenName;
    private TextView tv_tweets;
    private TextView tv_followers;
    private TextView tv_following;
    private TextView tv_description;
    private LinearLayout ll_side;

    public static final String EXTRA_POSITION = "position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetail);

        Intent intent = getIntent();
        int position = intent.getIntExtra(EXTRA_POSITION, -1);

        Tweet tweet = TweetModel.getInstance().getTweets().get(position);
        User user = tweet.getTweep();

        String username = user.getName();

        iv_userBanner = (ImageView) findViewById(R.id.iv_detail_userBanner);
        iv_userPicture = (ImageView) findViewById(R.id.iv_detail_userPicture);
        tv_userName = (TextView) findViewById(R.id.tv_detail_username_a);
        tv_screenName = (TextView) findViewById(R.id.tv_detail_screenname);
        tv_tweets = (TextView) findViewById(R.id.tv_detail_tweets);
        tv_followers = (TextView) findViewById(R.id.tv_detail_followers);
        tv_following = (TextView) findViewById(R.id.tv_detail_following);
        tv_description = (TextView) findViewById(R.id.tv_detail_description);
        ll_side = (LinearLayout) findViewById(R.id.ll_side);

        String screenname = user.getScreenName();
        int tweetCount = user.getTweetCount();
        int followerCount = user.getFollowerCount();
        int followingCount = user.getFollowingCount();
        String description = user.getDescription();
        int color = Color.parseColor("#" + user.getUserBackgroundHexCode());


        if (user.getUserProfileBanner() == null) {
            iv_userBanner.setImageDrawable(getDrawable(R.drawable.clouds));
        } else {
            iv_userBanner.setImageDrawable(user.getUserProfileBanner());
        }
        iv_userPicture.setImageDrawable(user.getUserImage());
        tv_userName.setText(user.getName() + "");
        tv_screenName.setText(screenname + "");
        tv_tweets.setText(tweetCount + "");
        tv_followers.setText(followerCount + "");
        tv_following.setText(followingCount + "");
        tv_description.setText(description + "");
        ll_side.setBackgroundColor(color);

    }
}
