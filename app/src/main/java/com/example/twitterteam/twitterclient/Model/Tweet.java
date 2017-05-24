package com.example.twitterteam.twitterclient.Model;

import java.util.Date;

/**
 * Created by Robert on 3-5-2017.
 */

public class Tweet {
    private String createdAt;
    private long id;
    private String idString;
    private String text;
    private User tweep;
    private static long lastAssignedID = 0;
    private int retweets;
    private int likes;

    /**
     * In case the id is given (for example in the JSON), this is the constructor to use
     *
     * @param createdAt Date of creation
     * @param id        Tweet id
     * @param idString  Tweet id in String
     * @param text      Content of the tweet
     * @param tweep     The user that has sent the tweet
     */
    public Tweet(String createdAt, long id, String idString, String text, User tweep, int retweets, int likes) {
        this.createdAt = createdAt;
        this.id = id;
        lastAssignedID = id;
        this.idString = idString;
        this.text = text;
        this.tweep = tweep;
        this.retweets = retweets;
        this.likes = likes;
    }

    /**
     * In case the id is not given, this is the constructor to use
     *
     * @param createdAt Date of creation
     * @param text      Content of the tweet
     * @param tweep     The user that has sent the tweet
     */
    public Tweet(String createdAt, String text, User tweep) {
        this.createdAt = createdAt;
        this.text = text;
        this.id = lastAssignedID++;
        this.idString = String.valueOf(this.id);
        this.tweep = tweep;

    }

    public String getCreatedAt() {
        return createdAt;
    }

    public long getId() {
        return id;
    }

    public String getIdString() {
        return idString;
    }

    public String getText() {
        return text;
    }

    public User getTweep() {
        return tweep;
    }

    public static long getLastAssignedID() {
        return lastAssignedID;
    }

    public int getRetweets() {
        return retweets;
    }

    public int getLikes() {
        return likes;
    }

    public String getCompressedCreatedAt() {
        String[] splitted = createdAt.split(" ");
        String compressedCreatedAt = splitted[0] + " " + splitted[1] + " " + splitted[2];
        return compressedCreatedAt;
    }

}
