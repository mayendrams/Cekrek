package com.mayendrams.cekrek.database;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class api_client {

    private static final String BASE_URL = "https://cekrekfoto.000webhostapp.com/";
    private static Retrofit retrofit;

    public static Retrofit getApiClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

}
