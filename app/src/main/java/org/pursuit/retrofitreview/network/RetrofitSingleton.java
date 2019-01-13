package org.pursuit.retrofitreview.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static Retrofit thisInstance;

    public static Retrofit getInstance() {
        if (thisInstance != null) {
            return thisInstance;
        }
        thisInstance = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return thisInstance;
    }

    private RetrofitSingleton() {
    }
}