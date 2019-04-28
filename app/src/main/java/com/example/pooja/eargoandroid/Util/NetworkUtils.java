package com.example.pooja.eargoandroid.Util;

import com.example.pooja.eargoandroid.Models.CompleteWeatherModel;
import com.example.pooja.eargoandroid.Interface.CustomAdapter;
import com.example.pooja.eargoandroid.Models.DailyData;
import com.example.pooja.eargoandroid.Retrofit.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkUtils {

    static RetrofitService service;
    private static List<DailyData> list;
    static CustomAdapter customAdapter;

    public static void loadData(final CustomAdapter adapter) {
        service = APIUtils.getRetrofitService();
        service.getWeatherDetails().enqueue(new Callback<CompleteWeatherModel>() {
            @Override
            public void onResponse(Call<CompleteWeatherModel> call, Response<CompleteWeatherModel> response) {
                if (response.isSuccessful()) {
                    customAdapter = adapter;
                    customAdapter.PopulatelistItem(response.body().getDaily().getData());
                } else {
                    int statusCode = response.code();
                    list = null;
                }
            }

            @Override
            public void onFailure(Call<CompleteWeatherModel> call, Throwable t) {
                list = null;
            }
        });
    }


    public static List<DailyData> GetData() {
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }

}
