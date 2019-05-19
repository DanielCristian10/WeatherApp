package com.dan.weather.holders;


import android.content.Intent;

import com.google.gson.annotations.SerializedName;

public class Weather {
    private String country;
    private String temp;

    public Weather() {
        //do nothing
    }

    public Weather(String country, String temp) {
        this.country = country;
        this.temp = temp;
    }

    public String getcountry() {
        return country;
    }

    public void setcountry(String country) {
        this.country = country;
    }

    public String gettemp() {
        return temp;
    }

    public void settemp(String temp) {
        this.temp = temp;
    }



    @Override
    public String toString() {
        return "Weather{" +
                "country='" +country + '\'' +
                ", temp='" + temp + '\'' +
                '}';
    }
}
