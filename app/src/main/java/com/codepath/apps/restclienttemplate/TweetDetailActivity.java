package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class TweetDetailActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvScreenName;
    private TextView tvBody;
    private ImageView ivProfileImage;
    private ImageView ivAttachedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_detail);

        tvName = (TextView) findViewById(R.id.tvName);
        tvScreenName = (TextView) findViewById(R.id.tvScreenName);
        tvBody = (TextView) findViewById(R.id.tvBody);
        ivProfileImage = (ImageView) findViewById(R.id.ivProfileImage);
        ivAttachedImage = (ImageView) findViewById(R.id.ivAttachedImage);

        Tweet tweet = (Tweet) Parcels.unwrap(getIntent().getParcelableExtra(Tweet.class.getSimpleName()));

        tvName.setText(tweet.getUser().getName());
        tvScreenName.setText(tweet.getAtScreenName());
        tvBody.setText(tweet.getBody());
        Glide.with(this).load(tweet.getUser().getProfileImageUrl()).into(ivProfileImage);
        Glide.with(this).load(tweet.getImageUrl()).into(ivAttachedImage);
    }
}