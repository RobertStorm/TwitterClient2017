package com.example.twitterteam.twitterclient.View;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.twitterteam.twitterclient.Model.Tweet;
import com.example.twitterteam.twitterclient.Model.TweetModel;
import com.example.twitterteam.twitterclient.Model.User;
import com.example.twitterteam.twitterclient.R;

import java.util.List;

/**
 * Created by Robert on 3-5-2017.
 */

public class TweetAdapter extends ArrayAdapter<Tweet> {
    TextView tv_tweet;
    TextView tv_tweepName;
    TextView tv_tweepUserName;
    TextView tv_tweetDate;
    TextView tv_tweet_retweets;
    TextView tv_tweet_likes;


    public TweetAdapter(@NonNull Context context) {
        super(context, R.layout.list_item, TweetModel.getInstance().getTweets());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        tv_tweet = (TextView) convertView.findViewById(R.id.tv_tweet);
        tv_tweetDate = (TextView) convertView.findViewById(R.id.tv_tweetDate);
        tv_tweepName = (TextView) convertView.findViewById(R.id.tv_tweepName);
        tv_tweepUserName = (TextView) convertView.findViewById(R.id.tv_tweepUserName);
        tv_tweet_retweets = (TextView) convertView.findViewById(R.id.tv_tweet_retweets);
        tv_tweet_likes = (TextView) convertView.findViewById(R.id.tv_tweet_likes);

        Tweet tweet = TweetModel.getInstance().getTweets().get(position);
        User user = tweet.getTweep();

        tv_tweet.setText(tweet.getText());
        tv_tweetDate.setText(tweet.getCompressedCreatedAt());
        tv_tweepName.setText(user.getName());
        tv_tweepUserName.setText("@" + user.getScreenName());
        tv_tweet_retweets.setText("RETWEETS: " + tweet.getRetweets());
        tv_tweet_likes.setText("LIKES: " + tweet.getLikes());

        return convertView;
    }
}
