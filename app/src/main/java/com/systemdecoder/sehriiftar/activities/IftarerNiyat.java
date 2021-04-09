package com.systemdecoder.sehriiftar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.systemdecoder.sehriiftar.R;

public class IftarerNiyat extends AppCompatActivity {

    ImageView back_to_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iftarer_niyat);

        back_to_home = findViewById(R.id.back_to_home);

        back_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IftarerNiyat.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}