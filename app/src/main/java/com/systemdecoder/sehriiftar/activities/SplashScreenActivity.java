package com.systemdecoder.sehriiftar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.systemdecoder.sehriiftar.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    private Timer timer;
    private int progress = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final long period = 100;
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (progress < 100) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {}
                    });
                    progress++;
                }
                else {
                    timer.cancel();
                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 0, period);
    }
}