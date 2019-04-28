package com.example.pooja.eargoandroid.Retrofit;

import com.example.pooja.eargoandroid.Models.CompleteWeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    //https://api.darksky.net/forecast/36e9abcabba196d0902301250094b9ef/37.8267,-122.4233

    @GET("/forecast/36e9abcabba196d0902301250094b9ef/37.8267,-122.4233")
    public Call<CompleteWeatherModel> getWeatherDetails();

}
