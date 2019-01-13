package org.pursuit.retrofitreview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.pursuit.retrofitreview.controller.PhotoAdapter;
import org.pursuit.retrofitreview.model.Rovers;
import org.pursuit.retrofitreview.network.PhotoService;
import org.pursuit.retrofitreview.network.RetrofitSingleton;

import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "all_cameras";
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.NASARecyclerView);
        Retrofit retrofit = RetrofitSingleton.getInstance();
        PhotoService photoService = retrofit.create(PhotoService.class);
        Call<Rovers> puppy = photoService.getRovers();
        puppy.enqueue(new Callback<Rovers>() {
            @Override
            public void onResponse(Call<Rovers> call, Response<Rovers> response) {
                Log.d(TAG, "onResponse: " + response.body().getPhotos());
                recyclerView.setAdapter(new PhotoAdapter(Collections.singletonList(response.body().getPhotos())));
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<Rovers> call, Throwable t) {
                Log.d(TAG, "onResponse: " + t.toString());
            }
        });

    }
}
