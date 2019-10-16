package com.ceng319.rvr_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ScanActivity extends AppCompatActivity {
    static final int ADD_DEVICE_REQUEST_CODE = 0;

    private ImageView historyIcon;
    private ImageView lookupIcon;
    private ImageView settingsIcon;

    private ImageView resistorImg;
    private TextView resistorText;
    private ImageView scanBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Replace loading screen
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        setupMenuBar();

        resistorImg = findViewById(R.id.resistorImg);

        resistorText = findViewById(R.id.resistorText);

        scanBtn = findViewById(R.id.scanBtn);
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddDeviceActivity.class);
                startActivityForResult(intent, ADD_DEVICE_REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == ADD_DEVICE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String dev_id = data.getStringExtra("DEV_ID");
                Toast.makeText(getApplicationContext(), dev_id, Toast.LENGTH_SHORT).show();
            }
        }
    }

    void setupMenuBar() {
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

        settingsIcon = findViewById(R.id.settingsIcon);
        settingsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}
