package com.example.pooja.eargoandroid.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pooja.eargoandroid.Models.DailyData;
import com.example.pooja.eargoandroid.R;
import com.example.pooja.eargoandroid.Util.Utils;
import com.google.gson.Gson;

public class ItemInfo extends AppCompatActivity {

    DailyData data;
    TextView summary, lowtemp, hightemp, pressure, windSpeed, uvIndex, visibility, humidity, error;
    ImageView imgVw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Gson gson = new Gson();
        String target = getIntent().getStringExtra("itemData");
        data = gson.fromJson(target, DailyData.class);

        if (data != null) {
            summary = findViewById(R.id.txtSummary);
            lowtemp = findViewById(R.id.txtTemperatureLow);
            hightemp = findViewById(R.id.tmpHigh);
            pressure = findViewById(R.id.txtPressure);
            windSpeed = findViewById(R.id.windSpeed);
            uvIndex = findViewById(R.id.txtUVIndex);
            visibility = findViewById(R.id.visibility);
            humidity = findViewById(R.id.txtHumidity);
            imgVw = findViewById(R.id.imgVw);


            summary.setText(data.getSummary());
            lowtemp.setText(data.getTemperatureLow().toString());
            hightemp.setText(data.getTemperatureHigh().toString());
            pressure.setText(data.getPressure().toString());
            windSpeed.setText(data.getWindSpeed().toString());
            uvIndex.setText(data.getUvIndex().toString());
            visibility.setText(data.getVisibility().toString());
            humidity.setText(data.getHumidity().toString());
            Utils.SetImage(data.getIcon(), imgVw);
        } else {

            error = findViewById(R.id.errorMessage);
            error.setText(R.string.error_message);
        }

    }
}
