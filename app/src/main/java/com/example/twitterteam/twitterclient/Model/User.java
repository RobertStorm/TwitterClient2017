package com.example.twitterteam.twitterclient.Model;

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

    /**
     * @param userID         ID of the user
     * @param userIDString   ID of the user in a String
     * @param name           Username
     * @param screenName     Displayed username
     * @param location       User's location
     * @param description    User's description
     * @param url            User URL
     * @param createdAt      Date of User account creation
     * @param followerCount  Amount of followers of the User
     * @param followingCount Amount of users the User is following
     * @param tweetCount     Amount of tweets the User has posted
     * @param likeCount      Amount of likes the User has given
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
                int likeCount) {
        this.userID = userID;
        this.userIDString = userIDString;
        this.name = name;
        this.screenName = screenName;
        this.location = location;
        this.description = description;
        this.url = url;
        this.createdAt = createdAt;
        this.followerCount = followerCount;
        this.followingCount = followingCount;
        this.tweetCount = tweetCount;
        this.likeCount = likeCount;
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
}
