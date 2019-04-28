package com.example.pooja.eargoandroid.Util;

import com.example.pooja.eargoandroid.Retrofit.RetrofitClient;
import com.example.pooja.eargoandroid.Retrofit.RetrofitService;

public class APIUtils {
    public static final String BASE_URL = "https://api.darksky.net/";

    public static RetrofitService getRetrofitService() {
        return RetrofitClient.getClient(BASE_URL).create(RetrofitService.class);
    }
}
