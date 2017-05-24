package com.example.twitterteam.twitterclient.Activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.twitterteam.twitterclient.Fragment.ListFragment;
import com.example.twitterteam.twitterclient.Model.TweetModel;
import com.example.twitterteam.twitterclient.R;
import com.example.twitterteam.twitterclient.Task.ReadJSON;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity implements ListFragment.ListCallbacks {
    private InputStream is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
