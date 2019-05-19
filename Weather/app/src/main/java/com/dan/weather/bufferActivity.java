package com.dan.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class bufferActivity extends AppCompatActivity {
private Button btnWeather;
private Button btnMyplaces;
private Button btnMaps;
private Button btnMyProfile;
private Button btnLogOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buffer_layout);
        btnWeather = findViewById(R.id.button6);
        btnMyplaces = findViewById(R.id.button7);
        btnMaps = findViewById(R.id.button8);
        btnMyProfile = findViewById(R.id.button9);
        btnLogOut = findViewById(R.id.button10);
        setButtonListener();
    }

    private void setButtonListener() {
        btnWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeather();
            }
        });
        btnMyplaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMyplaces();
            }
        });
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Buy premium for maps",Toast.LENGTH_LONG).show();
            }
        });
        btnMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"stealing credit card info...",Toast.LENGTH_LONG).show();

            }
        });
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"you can't escape",Toast.LENGTH_LONG).show();

            }
        });

    }
    private void openWeather()
    {
        Intent intent = new Intent(this,forecastActivity.class);
        startActivity(intent);
    }
    private void openMyplaces()
    {
        Intent intent = new Intent(this, myplacesActivity.class);
        startActivity(intent);
    }
}
