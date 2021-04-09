package com.systemdecoder.sehriiftar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.systemdecoder.sehriiftar.R;

public class MainActivity extends AppCompatActivity {

    Dialog empty_district_dialog;
    public static final String DistrictPrefs = "DistrictPrefs";
    CardView rojar_niyat, iftarer_niyat, time_schedule, your_time, rojar_tatporjo, about_company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rojar_niyat = findViewById(R.id.rojar_niyat);
        iftarer_niyat = findViewById(R.id.iftarer_niyat);
        time_schedule = findViewById(R.id.time_schedule);
        your_time = findViewById(R.id.your_time);
        rojar_tatporjo = findViewById(R.id.rojar_tatporjo);
        about_company = findViewById(R.id.about_company);
        empty_district_dialog = new Dialog(this);

        SharedPreferences sharedPreferences = getSharedPreferences(DistrictPrefs, MODE_PRIVATE);

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
        time_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_iftarer_niyat = new Intent(MainActivity.this, DistrictList.class);
                startActivity(intent_iftarer_niyat);
            }
        });

        // User Schedule
        your_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPreferences.getString("district_dame", "") == null) {
                    Toast.makeText(MainActivity.this, "your_time", Toast.LENGTH_SHORT).show();
                } else {
                    emptyDistrictAlert();
                }
            }
        });

        // Rojar tatporjo
        rojar_tatporjo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.on_development_mood, Toast.LENGTH_SHORT).show();
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