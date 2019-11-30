package com.example.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClient {

    private static Retrofit retrofit;
    private static final String Base_url = "https://next.json-generator.com/api/json/get/";

    public static Retrofit getRetrofitInstance(){

        if (retrofit==null){
            retrofit =new Retrofit.Builder()
                        .baseUrl(Base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }
        return retrofit;

    }
}
