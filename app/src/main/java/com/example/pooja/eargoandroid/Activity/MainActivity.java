package com.example.pooja.eargoandroid.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.pooja.eargoandroid.Interface.CustomAdapter;
import com.example.pooja.eargoandroid.Interface.clickListener;
import com.example.pooja.eargoandroid.Models.DailyData;
import com.example.pooja.eargoandroid.Activity.ItemInfo;
import com.example.pooja.eargoandroid.R;
import com.example.pooja.eargoandroid.Util.NetworkUtils;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements clickListener {

    CustomAdapter adapter;
    RecyclerView recyclerVw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerVw = (RecyclerView) findViewById(R.id.recyclerVw);
        adapter = new CustomAdapter(this, new ArrayList<DailyData>(0), this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerVw.setLayoutManager(layoutManager);
        recyclerVw.setAdapter(adapter);
        NetworkUtils.loadData(adapter);

    }


    @Override
    public void onItemClick(DailyData item) {
        Intent intent = new Intent();
        Gson gS = new Gson();
        String target = gS.toJson(item);
        intent.putExtra("itemData", target);
        intent.setClass(this, ItemInfo.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                NetworkUtils.loadData(adapter);
                break;
            default:
                break;
        }

        return true;
    }
}
