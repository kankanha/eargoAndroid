package com.example.pooja.eargoandroid.Util;

import android.text.format.DateFormat;
import android.widget.ImageView;

import com.example.pooja.eargoandroid.R;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class Utils {


    public static String GetDate(int timestamp) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTimeInMillis(timestamp * 1000L);
        String date = DateFormat.format("MM-dd-yyyy", cal).toString();
        return date;
    }

    static HashMap<String, Integer> map = new HashMap<>();

    public static void PopulateMap() {
        map.put("partly-cloudy-day", R.drawable.cloudy_day);
        map.put("clear-day", R.drawable.sunny_day_weather_symbol);
        map.put("partly-cloudy-night", R.drawable.cloudy);
        map.put("clear-night", R.drawable.clear_night);
    }

    public static void SetImage(String state, ImageView imageView) {
        ImageView img = imageView;
        img.setImageResource(map.get(state));
    }
}
