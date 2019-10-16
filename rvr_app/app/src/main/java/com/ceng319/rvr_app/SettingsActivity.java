package com.ceng319.rvr_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SettingsActivity extends AppCompatActivity {
    private ImageView historyIcon;
    private ImageView lookupIcon;
    private ImageView scanIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setupMenuBar();
    }

    //This method is a template to interface with the menu bar
    //Each section sets up one of the four buttons
    void setupMenuBar() {
        scanIcon = findViewById(R.id.scanIcon);
        scanIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ScanActivity.class);
                startActivity(intent);
            }
        });
        historyIcon = findViewById(R.id.historyIcon);
        historyIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
                startActivity(intent);
            }
        });

        lookupIcon = findViewById(R.id.lookupIcon);
        lookupIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LookupActivity.class);
                startActivity(intent);
            }
        });



    }
}