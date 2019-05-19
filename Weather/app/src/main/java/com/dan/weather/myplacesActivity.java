package com.dan.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.dan.weather.adapters.OSRecyclerViewAdapter;
import com.dan.weather.holders.Weather;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import com.dan.weather.holders.Weather;


public class myplacesActivity extends AppCompatActivity {

    private static final String TAG = myplacesActivity.class.getSimpleName();
    private RecyclerView rvOs;
    private OSRecyclerViewAdapter adapter;
    private List<String> dataSet;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myplaces_screen);
        setListener();
        setupList();
        read();



    }
    private void setListener() {
        findViewById(R.id.textView3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                read();
            }
        });
        findViewById(R.id.btn_change_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDataSet();
                read();

            }
        });
    }

    private void read() {
        String fileContent = readFromTxt();

        convertJsonToObject(fileContent);
        parseJsonToObjectManual(fileContent);

    }

    private void setupList() {
        rvOs = findViewById(R.id.rv_dev);


        layoutManager = new LinearLayoutManager(this);  // use a linear layout manager vertical
//        layoutManager = new GridLayoutManager(this,3);  // use a grid layout manager with 3 columns
        rvOs.setLayoutManager(layoutManager);

        generateDataSet();

        adapter = new OSRecyclerViewAdapter(dataSet, this);
        adapter.setOSClickListener(new OSRecyclerViewAdapter.OsClickListener() {
            @Override
            public void onClick(String os) {
                Toast.makeText(myplacesActivity.this, os, Toast.LENGTH_SHORT).show();
            }
        });
        rvOs.setAdapter(adapter);
    }

    private String readFromTxt() {
        StringBuilder buf = new StringBuilder();
        InputStream json;
        try {
            json = getAssets().open("dataSet.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(json, StandardCharsets.UTF_8));
            String str;

            while ((str = in.readLine()) != null) {

                buf.append(str);
            }

            in.close();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
        Log.d(TAG, "buf = " + buf.toString());
        return buf.toString();
    }
    private void generateDataSet() {
        dataSet = new ArrayList<>();

    }




    private ArrayList<Weather> parseJsonToObjectManual(String dataSet) {
        ArrayList<Weather> weathers = new ArrayList<>();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(dataSet);

            Log.d(TAG, "jsonArray= " + jsonArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String country = ((JSONObject) jsonObject.get("sys")).getString("country");
                String temp = ((JSONObject) jsonObject.get("main")).getString("temp");
                Weather weather = new Weather(country,temp);

                weathers.add(weather);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "weathers= " + weathers.toString());

        return weathers;
    }


    private void changeDataSet() {
        for (int i = 0; i < dataSet.size(); i++) {
            dataSet.set(i, dataSet.get(i) + "- " + System.currentTimeMillis());
        }

        adapter.setOsList(dataSet);
    }

  private List<Weather> convertJsonToObject(String dataSet) {
      Gson gson = new Gson();

      List<Weather> weathers;
      weathers = gson.fromJson(dataSet, new TypeToken<List<Weather>>() {
      }.getType());


      Log.d(TAG, "weathers= " + weathers.toString());

      return weathers;
  }
}
