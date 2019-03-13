package org.pursuit.nasa_roverview.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitNASASingleton {
    private static Retrofit NASARetroInstance;

    public static Retrofit getInstance() {
        if (NASARetroInstance != null) {
            return NASARetroInstance;
        }
        NASARetroInstance = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return NASARetroInstance;
    }

    private RetrofitNASASingleton() {
    }
}
