package com.systemdecoder.sehriiftar.activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.systemdecoder.sehriiftar.BuildConfig;
import com.systemdecoder.sehriiftar.R;

public class MainActivity extends AppCompatActivity {

    public static final String DistrictPrefs = "DistrictPrefs";
    Dialog empty_district_dialog;
    CardView rojar_niyat, iftarer_niyat, time_schedule, your_time, rojar_tatporjo, about_company;
    TextView version_code;
    FloatingActionButton share_now;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar drawer_id = findViewById(R.id.tool_bar);
//        drawer_id.inflateMenu(R.menu.menu);

        rojar_niyat = findViewById(R.id.rojar_niyat);
        iftarer_niyat = findViewById(R.id.iftarer_niyat);
//        time_schedule = findViewById(R.id.time_schedule);
//        your_time = findViewById(R.id.your_time);
        rojar_tatporjo = findViewById(R.id.rojar_tatporjo);
        about_company = findViewById(R.id.about_company);
        version_code = findViewById(R.id.version_code);
        share_now = findViewById(R.id.share_now);
        empty_district_dialog = new Dialog(this);

        version_code.setText("ভার্সনঃ " + BuildConfig.VERSION_NAME);

        SharedPreferences sharedPreferences = getSharedPreferences(DistrictPrefs, MODE_PRIVATE);

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

        // Rojar niyat
        rojar_niyat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_rojar_niyat = new Intent(MainActivity.this, RojarNiyat.class);
                startActivity(intent_rojar_niyat);
            }
        });

        // Iftarer niyat
        iftarer_niyat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_iftarer_niyat = new Intent(MainActivity.this, IftarerNiyat.class);
                startActivity(intent_iftarer_niyat);
            }
        });

        // Schedule
//        time_schedule.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent_iftarer_niyat = new Intent(MainActivity.this, DistrictList.class);
//                startActivity(intent_iftarer_niyat);
//            }
//        });

        // User Schedule
//        your_time.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (sharedPreferences.getString("district_dame", "") == null) {
//                    Toast.makeText(MainActivity.this, "your_time", Toast.LENGTH_SHORT).show();
//                } else {
//                    emptyDistrictAlert();
//                }
//            }
//        });

        // Rojar tatporjo
        rojar_tatporjo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_rojar_tatporjo = new Intent(MainActivity.this, RojayKoroniyo.class);
                startActivity(intent_rojar_tatporjo);
            }
        });

        // About Us
        about_company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_about_company = new Intent(MainActivity.this, AboutUs.class);
                startActivity(intent_about_company);
            }
        });
    }

    private void emptyDistrictAlert() {
        empty_district_dialog.setContentView(R.layout.empty_district_alert);
        empty_district_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView close_empty_district_dialog = empty_district_dialog.findViewById(R.id.close_empty_district_dialog);
        Button choose_district = empty_district_dialog.findViewById(R.id.choose_district);

        close_empty_district_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empty_district_dialog.dismiss();
            }
        });

        choose_district.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empty_district_dialog.dismiss();
                Intent intent = new Intent(MainActivity.this, DistrictList.class);
                startActivity(intent);
            }
        });

        empty_district_dialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}