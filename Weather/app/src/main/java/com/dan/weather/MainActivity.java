package com.dan.weather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import static com.dan.weather.R.layout.login_screen;


public class MainActivity extends AppCompatActivity {
    EditText editName;
    EditText editPass;
    public static final String USER_PREF = "USER_PREF" ;
    public static final String KEY_NAME = "KEY_NAME";
    public static final String KEY_PASS = "KEY_PASS";
    private Button pentaButton;
    private Button registerButton;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        pentaButton = findViewById(R.id.button);
        registerButton = findViewById(R.id.button2);
        editName = (EditText) findViewById(R.id.editName);
        editPass = (EditText) findViewById(R.id.editPass);
        sp = getSharedPreferences(USER_PREF, MODE_PRIVATE);
        setButtonListener();
    }
    private void setButtonListener() {
        pentaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(editName);
                save(editPass);
                openBuffer();
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();

            }
        });
    }

    public void openBuffer()
    {
        Intent intent = new Intent(this, bufferActivity.class);
        startActivity(intent);
    }
    public void openRegister()
    {
        Intent intent = new Intent (this, registerActivity.class);
        startActivity(intent);
    }

    public void save(View v) {
        String name  = editName.getText().toString();
        String pass  = editPass.getText().toString();
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_PASS, pass);
        editor.commit();
    }

    public void show(View v) {
        StringBuilder str = new StringBuilder();
        if (sp.contains(KEY_NAME)) {
            editName.setText(sp.getString(KEY_NAME, ""));
            editPass.setText(sp.getString(KEY_PASS, ""));
        }
    }

    public void clear(View v) {
        editName.setText("");
        editPass.setText("");
    }

}