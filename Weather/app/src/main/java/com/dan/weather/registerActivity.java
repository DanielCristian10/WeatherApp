package com.dan.weather;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Locale;

public class registerActivity extends AppCompatActivity{

    private Button regButton;
    private Button edtBirth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_screen);
        regButton = findViewById(R.id.button4);
        edtBirth = findViewById(R.id.editText13);
        setButtonListener();
    }
    private void setButtonListener() {
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openHome();
            }
        });
        edtBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            showDatePickerDialog();
            }
        });
    }
    public void openHome()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void showDatePickerDialog() {

        DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                edtBirth.setText(" ");
                int trueMonth;
                if(month!=11)
                trueMonth=(month+1)%12;
                else
                    trueMonth=12;
                edtBirth.setText(edtBirth.getText()+""+ dayOfMonth);
                edtBirth.setText(edtBirth.getText()+"/"+trueMonth);
                edtBirth.setText(edtBirth.getText()+"/"+year);


            }
        };

        DatePickerDialog DatePickerDialog = new DatePickerDialog(this, myDateListener, 1980, 1, 1);
        DatePickerDialog.show();
    }

}
