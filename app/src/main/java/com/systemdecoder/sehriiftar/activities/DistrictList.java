package com.systemdecoder.sehriiftar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.systemdecoder.sehriiftar.DistrictAdapter;
import com.systemdecoder.sehriiftar.R;

public class DistrictList extends AppCompatActivity {

    RecyclerView recyclerView;
    DistrictAdapter district_adapter;
    String[] district_name;
    ImageView back_to_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district_list);

        recyclerView = findViewById(R.id.district_lists);
        district_name = getResources().getStringArray(R.array.district_names);

        back_to_home = findViewById(R.id.back_to_home);

        back_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DistrictList.this, MainActivity.class);
                startActivity(intent);
            }
        });

        district_adapter = new DistrictAdapter(this, district_name);
        recyclerView.setAdapter(district_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}