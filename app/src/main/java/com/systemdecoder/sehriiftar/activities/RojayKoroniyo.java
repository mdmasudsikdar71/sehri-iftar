package com.systemdecoder.sehriiftar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.systemdecoder.sehriiftar.BuildConfig;
import com.systemdecoder.sehriiftar.R;

public class RojayKoroniyo extends AppCompatActivity {

    ImageView back_to_home;
    FloatingActionButton share_now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rojay_koroniyo);

        back_to_home = findViewById(R.id.back_to_home);
        share_now = findViewById(R.id.share_now);

        // Share Now
        share_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
                String shareMessage = "বাংলাভাষায় রোজা ও ইফতারের দোয়া সম্পূর্ণ বিজ্ঞাপনবিহীন পেতে আজই \"সেহরি ও ইফতার\" অ্যাপ্সটি ডাউনলোড করুন\n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID;
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "Choose One to share"));
            }
        });

        back_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RojayKoroniyo.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}