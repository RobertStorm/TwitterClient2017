package com.example.twitterteam.twitterclient.Model;

import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;

import com.example.twitterteam.twitterclient.Activity.MainActivity;
import com.example.twitterteam.twitterclient.R;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Robert on 3-5-2017.
 */

public class User {
    private long userID;
    private String userIDString;
    private String name;
    private String screenName;
    private String location;
    private String description;
    private String url;
    private String createdAt;
    private int followerCount;
    private int followingCount;
    private int tweetCount;
    private int likeCount;
    private String userBackgroundHexCode;
    private Drawable userProfileBackgroundImage;
    private Drawable userImage;
    private Drawable userProfileBanner;

    /**
     * @param userID                     ID of the user
     * @param userIDString               ID of the user in a String
     * @param name                       Username
     * @param screenName                 Displayed username
     * @param location                   User's location
     * @param description                User's description
     * @param url                        User URL
     * @param createdAt                  Date of User account creation
     * @param followerCount              Amount of followers of the User
     * @param followingCount             Amount of users the User is following
     * @param tweetCount                 Amount of tweets the User has posted
     * @param likeCount                  Amount of likes the User has given
     * @param userBackgroundHexCode      Hexcode of the background color of the user
     * @param userImage                  URL of the user image
     * @param userProfileBackgroundImage URL of the user's profile image
     * @param userProfileBanner          URL of the user's profile banner
     */
    public User(long userID,
                String userIDString,
                String name,
                String screenName,
                String location,
                String description,
                String url,
                String createdAt,
                int followerCount,
                int followingCount,
                int tweetCount,
                int likeCount,
                String userBackgroundHexCode,
                String userProfileBackgroundImage,
                String userImage,
                String userProfileBanner) {
        this.userID = userID;
        this.userIDString = userIDString;
        this.name = name;
        this.screenName = "@" + screenName;
        this.location = location;
        this.description = description;
        this.url = url;
        this.createdAt = createdAt;
        this.followerCount = followerCount;
        this.followingCount = followingCount;
        this.tweetCount = tweetCount;
        this.likeCount = likeCount;
        this.userBackgroundHexCode = userBackgroundHexCode;
        this.userProfileBackgroundImage = LoadImageFromWebOperations(userProfileBackgroundImage.replaceAll("\\\\", ""));
        this.userImage = LoadImageFromWebOperations(userImage.replaceAll("\\\\", ""));
        if (!userProfileBanner.equals("no img")) {
            this.userProfileBanner = LoadImageFromWebOperations(userProfileBanner.replaceAll("\\\\", ""));
        } else {
            this.userProfileBanner = null;
        }
    }

    public long getUserID() {
        return userID;
    }

    public String getUserIDString() {
        return userIDString;
    }

    public String getName() {
        return name;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public int getTweetCount() {
        return tweetCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public String getUserBackgroundHexCode() {
        return userBackgroundHexCode;
    }

    public Drawable getUserProfileBackgroundImage() {
        return userProfileBackgroundImage;
    }

    public Drawable getUserImage() {
        return userImage;
    }

    public Drawable getUserProfileBanner() {
        return userProfileBanner;
    }

    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
}
